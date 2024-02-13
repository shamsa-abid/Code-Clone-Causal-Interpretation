import * as vscode from 'vscode';
import * as fs from 'fs';
import * as path from 'path';
import { getAnnotationFilePath, getConfiguration, getCloneLabelsFilePath } from './configuration';
import { setDecorations } from './decoration/decoration';

export interface Position {
    line: number;
    character: number;
}

export interface Note {
    fileName: string;
    fileLine: number;
    positionStart: Position;
    positionEnd: Position;
    text: string;
    codeSnippet: string;
    status: 'pending' | 'done' | 'core-sim' | 'noncore-sim' | 'core-diff' | 'noncore-diff' | 'core' | 'noncore' | 'diff' | 'noncorediff';
    id: number;
    createdAt: Date;
    resolvedAt: Date | undefined;
}

export interface CloneFile {
    fileName: string;    
    text: string;   
    status: 'clone' | 'notclone' | 'clone-ext';
    id: number;
    createdAt: Date;
    resolvedAt: Date | undefined;
}

export type Label = {
    "fileName" : string,
    "labeltext" : string,
    "codeSnippet": string, 
    "LineStart" : number,
    "CharStart" : number,
    "LineEnd": number,
    "CharEnd": number,
    "status": string
}; 

export type CloneLabel = {
    "fileName" : string,
    "status": string
}; 

export interface NotesDb {
    notes: Note[];
    nextId: number;
}

export interface ClonesDb {
    clones: CloneFile[];
    nextId: number;
}

export const getNotesDb = (): NotesDb => {
    const annotationFile = getAnnotationFilePath();
    // const annotationFile = getConfiguration().filespathtosavefiles + 'annotations.json';
    const rawdata = fs.readFileSync(annotationFile, 'utf8');
    let annotations = JSON.parse(rawdata);
    return annotations;
};

export const getClonesDb = (): ClonesDb => {
    const annotationFile = getCloneLabelsFilePath();
    //const annotationFile = getConfiguration().filespathtosavefiles + 'clonesdb.json';
    const rawdata = fs.readFileSync(annotationFile, 'utf8');
    let annotations = JSON.parse(rawdata);
    return annotations;
};

export const getNotes = (): Note[] => {
    return getNotesDb().notes;
};

export const getCloneLabels = (): CloneFile[] => {
    return getClonesDb().clones;
};

export const getNextId = (): number => {
    return getNotesDb().nextId;
};

export const getNextCloneId = (): number => {
    return getClonesDb().nextId;
};

export const saveDb = (db: NotesDb) => {
    const data = JSON.stringify(db);
    fs.writeFileSync(getAnnotationFilePath(), data);
    vscode.commands.executeCommand('code-annotation.refreshEntry');
};

export const saveClonesDb = (db: ClonesDb) => {
    const data = JSON.stringify(db);
    fs.writeFileSync(getCloneLabelsFilePath(), data);
    vscode.commands.executeCommand('clone-annotation.refreshEntry');
};


export const saveNotes = (notes: Note[]) => {
    let db = getNotesDb();

    // Replace notes by the one passed
    db.notes = notes;

    // Save Db in JSON file
    saveDb(db);
};

export const saveClones = (clones: CloneFile[]) => {
    let db = getClonesDb();

    // Replace notes by the one passed
    db.clones = clones;

    // Save Db in JSON file
    saveClonesDb(db);
};

const createNote = (annotationText: string, fromSelection: boolean) => {
    const nextId = getNextId();

    let codeSnippet = '';
    let fileName = '';
    let selection = undefined;
    let positionStart: Position = {line: 0, character: 0};
    let positionEnd: Position = {line: 0, character: 0};

    const editor = vscode.window.activeTextEditor;
    if (fromSelection && editor) {
        const workspaceFolders = vscode.workspace.workspaceFolders;
        const workspacePath = workspaceFolders ? workspaceFolders[0].uri.fsPath : '';
        const filePath = editor.document.uri.fsPath;
        fileName = path.relative(workspacePath, filePath);
        selection = editor.selection;
        if (selection) {
            codeSnippet = editor.document.getText(selection);
            positionStart = { line: selection.start.line, character: selection.start.character };
            positionEnd = { line: selection.end.line, character: selection.end.character };
        }
    }
    const note: Note = {
        fileName: fileName,
        fileLine: selection ? selection.start.line : 0,
        positionStart: positionStart,
        positionEnd: positionEnd,
        text: annotationText,
        codeSnippet: codeSnippet,
        status: 'pending',
        id: nextId,
        createdAt: new Date(),
        resolvedAt: undefined
    };
    return note;
};


const createCloneLabel = (annotationText: string, fromSelection: boolean) => {
    const nextId = getNextCloneId();

    // let codeSnippet = '';
    let fileName = '';
    // let selection = undefined;
    // let positionStart: Position = {line: 0, character: 0};
    // let positionEnd: Position = {line: 0, character: 0};

    const editor = vscode.window.activeTextEditor;
    if (editor) {
        const workspaceFolders = vscode.workspace.workspaceFolders;
        const workspacePath = workspaceFolders ? workspaceFolders[0].uri.fsPath : '';
        const filePath = editor.document.uri.fsPath;
        fileName = path.relative(workspacePath, filePath);
    }
    
    const clonelabel: CloneFile = {
        fileName: fileName,        
        text: annotationText,        
        status: 'clone',
        id: nextId,
        createdAt: new Date(),
        resolvedAt: undefined
    };
    return clonelabel;
};

const createExtCloneLabel = (annotationText: string, fromSelection: boolean) => {
    const nextId = getNextCloneId();

    // let codeSnippet = '';
    let fileName = '';
    // let selection = undefined;
    // let positionStart: Position = {line: 0, character: 0};
    // let positionEnd: Position = {line: 0, character: 0};

    const editor = vscode.window.activeTextEditor;
    if (editor) {
        const workspaceFolders = vscode.workspace.workspaceFolders;
        const workspacePath = workspaceFolders ? workspaceFolders[0].uri.fsPath : '';
        const filePath = editor.document.uri.fsPath;
        fileName = path.relative(workspacePath, filePath);
    }
    
    const clonelabel: CloneFile = {
        fileName: fileName,        
        text: annotationText,        
        status: 'clone-ext',
        id: nextId,
        createdAt: new Date(),
        resolvedAt: undefined
    };
    return clonelabel;
};


const createNonCloneLabel = (annotationText: string, fromSelection: boolean) => {
    const nextId = getNextCloneId();

    // let codeSnippet = '';
    let fileName = '';
    // let selection = undefined;
    // let positionStart: Position = {line: 0, character: 0};
    // let positionEnd: Position = {line: 0, character: 0};

    const editor = vscode.window.activeTextEditor;
    if (editor) {
        const workspaceFolders = vscode.workspace.workspaceFolders;
        const workspacePath = workspaceFolders ? workspaceFolders[0].uri.fsPath : '';
        const filePath = editor.document.uri.fsPath;
        fileName = path.relative(workspacePath, filePath);
    }
    
    const nonclonelabel: CloneFile = {
        fileName: fileName,        
        text: annotationText,        
        status: 'notclone',
        id: nextId,
        createdAt: new Date(),
        resolvedAt: undefined
    };
    return nonclonelabel;
};

const createCoreLabel = (annotationText: string, fromSelection: boolean) => {
    const nextId = getNextId();

    let codeSnippet = '';
    let fileName = '';
    let selection = undefined;
    let positionStart: Position = {line: 0, character: 0};
    let positionEnd: Position = {line: 0, character: 0};

    const editor = vscode.window.activeTextEditor;
    if (fromSelection && editor) {
        const workspaceFolders = vscode.workspace.workspaceFolders;
        const workspacePath = workspaceFolders ? workspaceFolders[0].uri.fsPath : '';
        const filePath = editor.document.uri.fsPath;
        fileName = path.relative(workspacePath, filePath);
        selection = editor.selection;
        if (selection) {
            codeSnippet = editor.document.getText(selection);
            positionStart = { line: selection.start.line, character: selection.start.character };
            positionEnd = { line: selection.end.line, character: selection.end.character };
        }
    }
    const note: Note = {
        fileName: fileName,
        fileLine: selection ? selection.start.line : 0,
        positionStart: positionStart,
        positionEnd: positionEnd,
        text: annotationText,
        codeSnippet: codeSnippet,
        status: 'core-sim',
        id: nextId,
        createdAt: new Date(),
        resolvedAt: undefined
    };
    return note;
};

const createDiffLabel = (annotationText: string, fromSelection: boolean) => {
    const nextId = getNextId();

    let codeSnippet = '';
    let fileName = '';
    let selection = undefined;
    let positionStart: Position = {line: 0, character: 0};
    let positionEnd: Position = {line: 0, character: 0};

    const editor = vscode.window.activeTextEditor;
    if (fromSelection && editor) {
        const workspaceFolders = vscode.workspace.workspaceFolders;
        const workspacePath = workspaceFolders ? workspaceFolders[0].uri.fsPath : '';
        const filePath = editor.document.uri.fsPath;
        fileName = path.relative(workspacePath, filePath);
        
        selection = editor.selection;
        if (selection) {
            codeSnippet = editor.document.getText(selection);
            positionStart = { line: selection.start.line, character: selection.start.character };
            positionEnd = { line: selection.end.line, character: selection.end.character };
        }
    }
    const note: Note = {
        fileName: fileName,
        fileLine: selection ? selection.start.line : 0,
        positionStart: positionStart,
        positionEnd: positionEnd,
        text: annotationText,
        codeSnippet: codeSnippet,
        status: 'core-diff',
        id: nextId,
        createdAt: new Date(),
        resolvedAt: undefined
    };
    return note;
};

const createNoncoreDiffLabel = (annotationText: string, fromSelection: boolean) => {
    const nextId = getNextId();

    let codeSnippet = '';
    let fileName = '';
    let selection = undefined;
    let positionStart: Position = {line: 0, character: 0};
    let positionEnd: Position = {line: 0, character: 0};

    const editor = vscode.window.activeTextEditor;
    if (fromSelection && editor) {
        const workspaceFolders = vscode.workspace.workspaceFolders;
        const workspacePath = workspaceFolders ? workspaceFolders[0].uri.fsPath : '';
        const filePath = editor.document.uri.fsPath;
        fileName = path.relative(workspacePath, filePath);
        
        selection = editor.selection;
        if (selection) {
            codeSnippet = editor.document.getText(selection);
            positionStart = { line: selection.start.line, character: selection.start.character };
            positionEnd = { line: selection.end.line, character: selection.end.character };
        }
    }
    const note: Note = {
        fileName: fileName,
        fileLine: selection ? selection.start.line : 0,
        positionStart: positionStart,
        positionEnd: positionEnd,
        text: annotationText,
        codeSnippet: codeSnippet,
        status: 'noncore-diff',
        id: nextId,
        createdAt: new Date(),
        resolvedAt: undefined
    };
    return note;
};

const createNonCoreLabel = (annotationText: string, fromSelection: boolean) => {
    const nextId = getNextId();

    let codeSnippet = '';
    let fileName = '';
    let selection = undefined;
    let positionStart: Position = {line: 0, character: 0};
    let positionEnd: Position = {line: 0, character: 0};

    const editor = vscode.window.activeTextEditor;
    if (fromSelection && editor) {
        const workspaceFolders = vscode.workspace.workspaceFolders;
        const workspacePath = workspaceFolders ? workspaceFolders[0].uri.fsPath : '';
        const filePath = editor.document.uri.fsPath;
        fileName = path.relative(workspacePath, filePath);
        
        selection = editor.selection;
        if (selection) {
            codeSnippet = editor.document.getText(selection);
            positionStart = { line: selection.start.line, character: selection.start.character };
            positionEnd = { line: selection.end.line, character: selection.end.character };
        }
    }
    const note: Note = {
        fileName: fileName,
        fileLine: selection ? selection.start.line : 0,
        positionStart: positionStart,
        positionEnd: positionEnd,
        text: annotationText,
        codeSnippet: codeSnippet,
        status: 'noncore-sim',
        id: nextId,
        createdAt: new Date(),
        resolvedAt: undefined
    };
    return note;
};
const createNoteFromSelection = (annotationText: string) => {
    return createNote(annotationText, true);
};

const createCoreLabelFromSelection = (annotationText: string) => {
    return createCoreLabel(annotationText, true);
};

const createNonCoreLabelFromSelection = (annotationText: string) => {
    return createNonCoreLabel(annotationText, true);
};

const createDiffLabelFromSelection = (annotationText: string) => {
    return createDiffLabel(annotationText, true);
};

const createNoncoreDiffLabelFromSelection = (annotationText: string) => {
    return createNoncoreDiffLabel(annotationText, true);
};

const createCloneLabelm = (annotationText: string) => {
    return createCloneLabel(annotationText, true);
};
const createExtCloneLabelm = (annotationText: string) => {
    return createExtCloneLabel(annotationText, true);
};

const createNonCloneLabelm = (annotationText: string) => {
    return createNonCloneLabel(annotationText, true);
};

const createPlainNote = (annotationText: string) => {
    return createNote(annotationText, false);
};

const addNoteToDb = (note: Note) => {
    let db = getNotesDb();

    db.notes.push(note);
    db.nextId++;

    saveDb(db);
    vscode.window.showInformationMessage('Annotation saved!');
};


const addCloneLabelToDb = (clone: CloneFile) => {
    let db = getClonesDb();

    db.clones.push(clone);
    db.nextId++;

    saveClonesDb(db);
    vscode.window.showInformationMessage('Clone Label saved!');
};

const getTODOFromSelectedText = (): string | undefined => {
    const editor = vscode.window.activeTextEditor;
    const selectedText = editor?.selection ? editor.document.getText(editor.selection) : '';
    const todoSelector = /\/\/\s*(TODO|FIX):\s*(.*)/;
    let matchArray = selectedText.match(todoSelector);
    if (matchArray && matchArray.length) {
        return matchArray[2];
    }
    for (const custom of getConfiguration().customTODO) {
        try {
            const customMatch = selectedText.match(custom);
            if (customMatch && customMatch.length) {
                // Use the second group to be consistent with the standard regex above
                if (!customMatch[2]) {
                    vscode.window.showWarningMessage(`Custom TODO RegEx (${custom}) doesn't have atleast two capture groups`);
                } else {
                    return customMatch[2];
                }
            }
        } catch (error) {
            vscode.window.showErrorMessage(`Error checking custom regex`);
            continue;
        }
    }
    return undefined;
};

const getPlaceHolderLineFromText = (): string | undefined => {
    const todoText = getTODOFromSelectedText();
    if (todoText)
    { return todoText; }

    // If there's no todo, use the first line from the text
    const editor = vscode.window.activeTextEditor;
    let selectedText = editor?.selection ? editor.document.getText(editor.selection) : '';
    return selectedText.split(/\r?\n/)[0].trim();
};

export const addNote = async () => {
    const editor = vscode.window.activeTextEditor;
    if (editor) {
        const todoText = getPlaceHolderLineFromText();
        let annotationText = await vscode.window.showInputBox({ placeHolder: 'Give the annotation some text...', value: todoText });
        if (annotationText) {
            addNoteToDb(createNoteFromSelection(annotationText));
        }
    }
    setDecorations();
};

export const addCloneLabel = async () => {
    addCloneLabelToDb(createCloneLabelm('clone'));     
    setDecorations();
};

export const addExtCloneLabel = async () => {
    addCloneLabelToDb(createExtCloneLabelm('clone-ext'));     
    setDecorations();
};

export const addNonCloneLabel = async () => {
    addCloneLabelToDb(createNonCloneLabelm('nonclone'));     
    setDecorations();
};

export const addCoreLabel = async () => {
    
    // addNoteToDb(createCoreLabelFromSelection('core-sim'));     
    // setDecorations();

    const editor = vscode.window.activeTextEditor;
    if (editor) {
        const todoText = 'core-sim';
        let annotationText = await vscode.window.showInputBox({ placeHolder: 'Give the annotation some text...', value: todoText });
        if (annotationText) {
            addNoteToDb(createCoreLabelFromSelection(annotationText));
        }
    }
    setDecorations();

};

export const addNonCoreLabel = async () => {
    // addNoteToDb(createNonCoreLabelFromSelection('noncore-sim'));
     
    // setDecorations();
    const editor = vscode.window.activeTextEditor;
    if (editor) {
        const todoText = 'noncore-sim';
        let annotationText = await vscode.window.showInputBox({ placeHolder: 'Give the annotation some text...', value: todoText });
        if (annotationText) {
            addNoteToDb(createNonCoreLabelFromSelection(annotationText));
        }
    }
    setDecorations();
};

export const addDiffLabel = async () => {
    // addNoteToDb(createDiffLabelFromSelection('core-diff'));     
    // setDecorations();
    const editor = vscode.window.activeTextEditor;
    if (editor) {
        const todoText = 'core-diff';
        let annotationText = await vscode.window.showInputBox({ placeHolder: 'Give the annotation some text...', value: todoText });
        if (annotationText) {
            addNoteToDb(createDiffLabelFromSelection(annotationText));
        }
    }
    setDecorations();
};

export const addNoncoreDiffLabel = async () => {
    // addNoteToDb(createNoncoreDiffLabelFromSelection('noncore-diff'));     
    // setDecorations();
    const editor = vscode.window.activeTextEditor;
    if (editor) {
        const todoText = 'noncore-diff';
        let annotationText = await vscode.window.showInputBox({ placeHolder: 'Give the annotation some text...', value: todoText });
        if (annotationText) {
            addNoteToDb(createNoncoreDiffLabelFromSelection(annotationText));
        }
    }
    setDecorations();
};

export const addPlainNote = async () => {
    const annotationText = await vscode.window.showInputBox({ placeHolder: 'Give the annotation some text...' });
    if (annotationText) {
        addNoteToDb(createPlainNote(annotationText));
    }
};