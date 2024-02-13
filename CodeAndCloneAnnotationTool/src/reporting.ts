import * as vscode from 'vscode';
import { appendFileSync } from 'fs';
import { getNotes, Note, Label, CloneLabel, getCloneLabels, CloneFile } from './note-db';
import { getRelativePathForFileName,
    getTimeStampsString } from './utils';
import { getConfiguration } from './configuration';
import * as fs from 'fs';

const getCodeSnippetString = (note: Note): [string, number, number, number, number] => {
    const moreThanOneLine = note.positionEnd.line !== note.positionStart.line;
    const LineStart = note.positionStart.line;
    const LineEnd = note.positionEnd.line;
    const CharStart = note.positionStart.character;
    const CharEnd = note.positionEnd.character;
    const firstLineOffset = moreThanOneLine ? note.positionStart.character : 0;
    let codeSnippet = note.codeSnippet;
    if (moreThanOneLine && firstLineOffset) {
        const offsetSpace = Array(firstLineOffset + 1).join(' ');
        codeSnippet = offsetSpace + codeSnippet;
    }
    return [codeSnippet,LineStart,LineEnd,CharStart,CharEnd];
};

// TODO: We should use Jinja or something like this to generate these markdown files
export const getNoteInMarkdown = (note: Note): string => {
    let result = ``;
    if (note.fileName.length > 0) {
        const [codeSnippet,LineStart,LineEnd,CharStart,CharEnd] = getCodeSnippetString(note)
        let re = {
            "fileName" : getRelativePathForFileName(note.fileName),
            "codeSnippet": codeSnippet, 
            "LineStart" : LineStart,
            "CharStart" : CharStart,
            "LineEnd": LineEnd,
            "CharEnd": CharEnd,
            "status": note.status
        } 
        let jsonData = JSON.stringify(re)
        result += `${jsonData}\n`;
    }
    return result;
};


export const getLabelInJson = (note: Note): Label => {

    // if (note.fileName.length > 0) {
        const [codeSnippet,LineStart,LineEnd,CharStart,CharEnd] = getCodeSnippetString(note)
       
        const newLabel: Label = {
            "fileName" : getRelativePathForFileName(note.fileName),
            "labeltext" : note.text,
            "codeSnippet": codeSnippet, 
            "LineStart" : LineStart,
            "CharStart" : CharStart,
            "LineEnd": LineEnd,
            "CharEnd": CharEnd,
            "status": note.status
        }      
    // }
      
    
    return newLabel;
};

export const getCloneLabelInJson = (note: CloneFile): CloneLabel => {

    // if (note.fileName.length > 0) {
        // const [codeSnippet,LineStart,LineEnd,CharStart,CharEnd] = getCodeSnippetString(note)
       
        const newLabel: CloneLabel = {
            "fileName" : getRelativePathForFileName(note.fileName),
            "status": note.status
        }      
    // }
      
    
    return newLabel;
};



export const getNotesInMarkdown = (): string => {
    const notes = getNotes();

    let result = '';

    for (let i in notes) {
        const note = notes[i];
        // if (note.status === 'core' || note.status === 'noncore') {
            result += getNoteInMarkdown(note);
        // }
    }

    return result;
};

export const getLabelsInJson = (): string => {
    const notes = getNotes();

    let result = '';
    let jsonDataArray = [];

    for (let i in notes) {
        const note = notes[i];
        if (note.status === 'core-sim' || note.status === 'noncore-sim'  || note.status === 'core-diff' || note.status === 'noncore-diff' || note.status === 'core' || note.status === 'noncore'  || note.status === 'diff' || note.status === 'noncorediff') {
            jsonDataArray.push(getLabelInJson(note));
        }
    }
    result = JSON.stringify(jsonDataArray)

    return result;
};


export const getCloneLabelsInJson = (): string => {
    const notes = getCloneLabels();

    let result = '';
    let jsonDataArray = [];
    let csv = ''

    

    for (let i in notes) {
        const note = notes[i];
        if (note.status === 'clone' || note.status === 'notclone' || note.status === 'clone-ext') {
            jsonDataArray.push(getCloneLabelInJson(note));
            //code to wipe out file data
            let clonelabel = getCloneLabelInJson(note)
            csv = csv.concat(clonelabel.fileName+','+clonelabel.status+'\n');
            
        }
    }
    result = JSON.stringify(jsonDataArray)
    saveAsCSV(csv)
    return result;
};


export const generateMarkdownReport = (): void => {
    const newFile = vscode.Uri.parse('untitled:summary.md');

    vscode.workspace.openTextDocument(newFile).then(summaryFile => {
        const edit = new vscode.WorkspaceEdit();
        let notesSummary = getNotesInMarkdown();

        const existingContentRange = new vscode.Range(new vscode.Position(0, 0),
            new vscode.Position(summaryFile.lineCount + 1, 0));
        edit.replace(newFile, existingContentRange, notesSummary);

        return vscode.workspace.applyEdit(edit).then(success => {
            if (success) {
                vscode.window.showTextDocument(summaryFile, /*column=*/undefined, /*preserveFocus=*/false);
            } else {
                vscode.window.showInformationMessage('Error: Code Annotation could not generate a summary');
            }
        });
    });
};

export const generateJsonReportFile = (): void => {
    const newFile = vscode.Uri.parse('untitled:summary.json');

    vscode.workspace.openTextDocument(newFile).then(summaryFile => {
        const edit = new vscode.WorkspaceEdit();
        let notesSummary = getLabelsInJson();
        fs.writeFileSync(getConfiguration().filespathtosavefiles+'/codelabels.json', notesSummary);

        const existingContentRange = new vscode.Range(new vscode.Position(0, 0),
            new vscode.Position(summaryFile.lineCount + 1, 0));
        edit.replace(newFile, existingContentRange, notesSummary);

        return vscode.workspace.applyEdit(edit).then(success => {
            if (success) {
                vscode.window.showTextDocument(summaryFile, /*column=*/undefined, /*preserveFocus=*/false);
            } else {
                vscode.window.showInformationMessage('Error: Code Annotation could not generate a summary');
            }
        });
    });
};

export const generateJsonCloneReportFile = (): void => {
    const newFile = vscode.Uri.parse('untitled:clonesummary.json');

    vscode.workspace.openTextDocument(newFile).then(summaryFile => {
        const edit = new vscode.WorkspaceEdit();
        let notesSummary = getCloneLabelsInJson();
        fs.writeFileSync(getConfiguration().filespathtosavefiles+'/clonelabels.json', notesSummary);

        const existingContentRange = new vscode.Range(new vscode.Position(0, 0),
            new vscode.Position(summaryFile.lineCount + 1, 0));
        edit.replace(newFile, existingContentRange, notesSummary);

        return vscode.workspace.applyEdit(edit).then(success => {
            if (success) {
                vscode.window.showTextDocument(summaryFile, /*column=*/undefined, /*preserveFocus=*/false);
            } else {
                vscode.window.showInformationMessage('Error: Code Annotation could not generate a summary');
            }
        });
    });
};

export const saveAsCSV = (data: string): void => {
    
    try {
      let path = getConfiguration().filespathtosavefiles + '/clonesstatus.csv'
      fs.writeFileSync(path, data);
    } catch (err) {
      console.error(err);
    }
};
