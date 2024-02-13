import * as vscode from 'vscode';
import { getConfiguration } from '../configuration';
import { getNotes } from '../note-db';
import { NotesTree } from '../notes-tree';
import * as path from 'path'

const decorationType = vscode.window.createTextEditorDecorationType({
    dark: {
        backgroundColor: getConfiguration().decorationColors?.dark
    },
    light: {
        backgroundColor: getConfiguration().decorationColors?.light
    }
});

const coredecorationType = vscode.window.createTextEditorDecorationType({
    dark: {
        backgroundColor: getConfiguration().decorationColors?.core
    },
    light: {
        backgroundColor: getConfiguration().decorationColors?.lightcore
    }
});

const noncoredecorationType = vscode.window.createTextEditorDecorationType({
    dark: {
        backgroundColor: getConfiguration().decorationColors?.noncore
    },
    light: {
        backgroundColor: getConfiguration().decorationColors?.lightnoncore
    }
});

const diffdecorationType = vscode.window.createTextEditorDecorationType({
    dark: {
        backgroundColor: getConfiguration().decorationColors?.diff
    },
    light: {
        backgroundColor: getConfiguration().decorationColors?.lightdiff
    }
});

const noncorediffdecorationType = vscode.window.createTextEditorDecorationType({
    dark: {
        backgroundColor: getConfiguration().decorationColors?.noncorediff
    },
    light: {
        backgroundColor: getConfiguration().decorationColors?.lightnoncorediff
    }
});

export const setDecorations = (): void => {
    if (!getConfiguration().enableDecoration)
    { return; }

    const openEditors = vscode.window.visibleTextEditors;

    openEditors.forEach( editor => {
        const ranges: vscode.Range[] = [];
        getNotes().forEach( note => {
            const workspaceFolders = vscode.workspace.workspaceFolders;
            const workspacePath = workspaceFolders ? workspaceFolders[0].uri.fsPath : '';
            const filePath = editor.document.uri.fsPath;
            const fileName = path.relative(workspacePath, filePath);
            if (note.fileName === path.normalize(fileName) && (note.status === 'core-sim' || note.status === 'core')) {
                const positionStart = new vscode.Position(note.positionStart.line, note.positionStart.character);
                const positionEnd = new vscode.Position(note.positionEnd.line, note.positionEnd.character);
                ranges.push(new vscode.Range(positionStart, positionEnd));
            }
        });
        // editor.setDecorations(decorationType, []);
        editor.setDecorations(coredecorationType, ranges);
    });
    openEditors.forEach( editor => {
        const ranges: vscode.Range[] = [];
        getNotes().forEach( note => {
            const workspaceFolders = vscode.workspace.workspaceFolders;
            const workspacePath = workspaceFolders ? workspaceFolders[0].uri.fsPath : '';
            const filePath = editor.document.uri.fsPath;
            const fileName = path.relative(workspacePath, filePath);
            if (note.fileName === path.normalize(fileName) && (note.status === 'noncore-sim' || note.status === 'noncore')) {
                const positionStart = new vscode.Position(note.positionStart.line, note.positionStart.character);
                const positionEnd = new vscode.Position(note.positionEnd.line, note.positionEnd.character);
                ranges.push(new vscode.Range(positionStart, positionEnd));
            }
        });
        // editor.setDecorations(decorationType, []);
        editor.setDecorations(noncoredecorationType, ranges);
    });
    openEditors.forEach( editor => {
        const ranges: vscode.Range[] = [];
        getNotes().forEach( note => {            
            const workspaceFolders = vscode.workspace.workspaceFolders;
            const workspacePath = workspaceFolders ? workspaceFolders[0].uri.fsPath : '';
            const filePath = editor.document.uri.fsPath;
            const fileName = path.relative(workspacePath, filePath);
            if (note.fileName === path.normalize(fileName) && (note.status === 'core-diff' || note.status === 'diff')) {
                const positionStart = new vscode.Position(note.positionStart.line, note.positionStart.character);
                const positionEnd = new vscode.Position(note.positionEnd.line, note.positionEnd.character);
                ranges.push(new vscode.Range(positionStart, positionEnd));
            }
        });
        // editor.setDecorations(decorationType, []);
        editor.setDecorations(diffdecorationType, ranges);
    });
    openEditors.forEach( editor => {
        const ranges: vscode.Range[] = [];
        getNotes().forEach( note => {
            const workspaceFolders = vscode.workspace.workspaceFolders;
            const workspacePath = workspaceFolders ? workspaceFolders[0].uri.fsPath : '';
            const filePath = editor.document.uri.fsPath;
            const fileName = path.relative(workspacePath, filePath);
            if (note.fileName === path.normalize(fileName) && (note.status === 'noncore-diff' || note.status === 'noncorediff')) {
                const positionStart = new vscode.Position(note.positionStart.line, note.positionStart.character);
                const positionEnd = new vscode.Position(note.positionEnd.line, note.positionEnd.character);
                ranges.push(new vscode.Range(positionStart, positionEnd));
            }
        });
        // editor.setDecorations(decorationType, []);
        editor.setDecorations(noncorediffdecorationType, ranges);
    });
};

export function updateDecorations (context: vscode.ExtensionContext) {
    setDecorations();

    vscode.window.onDidChangeActiveTextEditor(editor => {
        if (editor) {
            setDecorations();
        }
    }, null, context.subscriptions);

    
}
