import * as vscode from 'vscode';
import * as fs from 'fs';
import {getConfiguration} from './configuration'

import { addNote, addPlainNote, addCoreLabel, addNonCoreLabel, addDiffLabel, addNoncoreDiffLabel, addCloneLabel, addNonCloneLabel, addExtCloneLabel } from './note-db';
import { generateJsonReportFile, generateMarkdownReport, generateJsonCloneReportFile } from './reporting';
import { NotesTree, TreeActions, CloneTreeActions, ClonesTree } from './notes-tree';
import { initializeStorageLocation, getAnnotationFilePath } from './configuration';
import { updateDecorations } from './decoration/decoration';

export function activate(context: vscode.ExtensionContext) {
    console.log('Extension "code-annotation" is now active!');

    // initializeStorageLocation(context.globalStoragePath);
    initializeStorageLocation(getConfiguration().filespathtosavefiles);

    const tree = new NotesTree();
    const treeActions = new TreeActions(tree);

    vscode.window.registerTreeDataProvider('codeAnnotationView', tree);
    vscode.commands.registerCommand('code-annotation.removeNote', treeActions.removeNote.bind(treeActions));
    // vscode.commands.registerCommand('code-annotation.checkAllNotes', treeActions.checkAllNotes.bind(treeActions));
    // vscode.commands.registerCommand('code-annotation.uncheckAllNotes', treeActions.uncheckAllNotes.bind(treeActions));
    vscode.commands.registerCommand('code-annotation.removeAllNotes', treeActions.removeAllNotes.bind(treeActions));
    // vscode.commands.registerCommand('code-annotation.checkNote', treeActions.checkNote.bind(treeActions));
    // vscode.commands.registerCommand('code-annotation.uncheckNote', treeActions.uncheckNote.bind(treeActions));
    vscode.commands.registerCommand('code-annotation.openNote', treeActions.openNote.bind(treeActions));
    vscode.commands.registerCommand('code-annotation.editNote', treeActions.editNote.bind(treeActions));
    vscode.commands.registerCommand('code-annotation.copyNote', treeActions.copyNote.bind(treeActions));
    vscode.commands.registerCommand('code-annotation.openNoteFromId', (id: string) => {
        treeActions.openNoteFromId(id);
    });

    const tree2 = new ClonesTree();
    const treeActions2 = new CloneTreeActions(tree2);

    vscode.window.registerTreeDataProvider('cloneAnnotationView', tree2);
    vscode.commands.registerCommand('clone-annotation.removeClone', treeActions2.removeClone.bind(treeActions2));
    // vscode.commands.registerCommand('code-annotation.checkAllNotes', treeActions.checkAllNotes.bind(treeActions));
    // vscode.commands.registerCommand('code-annotation.uncheckAllNotes', treeActions.uncheckAllNotes.bind(treeActions));
    // vscode.commands.registerCommand('code-annotation.removeAllNotes', treeActions.removeAllNotes.bind(treeActions));
    vscode.commands.registerCommand('clone-annotation.checkTrueClone', treeActions2.checkClone.bind(treeActions2));
    vscode.commands.registerCommand('clone-annotation.uncheckFalseClone', treeActions2.uncheckClone.bind(treeActions2));
    vscode.commands.registerCommand('clone-annotation.openClone', treeActions2.openCloneFile.bind(treeActions2));
    // vscode.commands.registerCommand('code-annotation.editNote', treeActions.editNote.bind(treeActions));
    // vscode.commands.registerCommand('code-annotation.copyNote', treeActions.copyNote.bind(treeActions));
    vscode.commands.registerCommand('clone-annotation.openCloneFromId', (id: string) => {
        treeActions2.openCloneFileFromId(id);
    });

    vscode.commands.registerCommand('code-annotation.summary', () => {
        // generateMarkdownReport();
        generateJsonReportFile();
    });

    vscode.commands.registerCommand('clone-annotation.summary', () => {
        // generateMarkdownReport();
        generateJsonCloneReportFile();
    });

    vscode.commands.registerCommand('code-annotation.clearAllNotes', async () => {
        const message = 'Are you sure you want to clear all notes? This cannot be reverted.';
        const enableAction = 'I\'m sure';
        const cancelAction = 'Cancel';
        const userResponse = await vscode.window.showInformationMessage(message, enableAction, cancelAction);
        const clearAllNotes = userResponse === enableAction ? true : false;

        if (clearAllNotes) {
            const annotationFile = getAnnotationFilePath();
            fs.unlinkSync(annotationFile);
            vscode.commands.executeCommand('code-annotation.refreshEntry');
            vscode.window.showInformationMessage('All notes cleared!');
        }
    });

    vscode.commands.registerCommand('code-annotation.addPlainNote', async () => {
        addPlainNote();
    });

    let disposable = vscode.commands.registerCommand('code-annotation.addNote', async () => {
        addNote();
    });

    let corelabeldisposable = vscode.commands.registerCommand('code-annotation.addCoreLabel', async () => {
        addCoreLabel();
    });

    let noncorelabeldisposable = vscode.commands.registerCommand('code-annotation.addNonCoreLabel', async () => {
        addNonCoreLabel();
    });

    let difflabeldisposable = vscode.commands.registerCommand('code-annotation.addDiffLabel', async () => {
        addDiffLabel();
    });

    let noncoredifflabeldisposable = vscode.commands.registerCommand('code-annotation.addNoncoreDiffLabel', async () => {
        addNoncoreDiffLabel();
    });

    let clonelabeldisposable = vscode.commands.registerCommand('clone-annotation.addCloneLabel', async () => {
        addCloneLabel();
    });

    let extclonelabeldisposable = vscode.commands.registerCommand('clone-annotation.addCloneExtLabel', async () => {
        addExtCloneLabel();
    });

    let nonclonelabeldisposable = vscode.commands.registerCommand('clone-annotation.addNonCloneLabel', async () => {
        addNonCloneLabel();
    });

    vscode.workspace.onDidChangeConfiguration(() => updateDecorations(context) );

    updateDecorations(context);
    tree.refresh();

    context.subscriptions.push(disposable);
    context.subscriptions.push(corelabeldisposable);
    context.subscriptions.push(noncorelabeldisposable);
    context.subscriptions.push(difflabeldisposable);
    context.subscriptions.push(noncoredifflabeldisposable);
    context.subscriptions.push(clonelabeldisposable);
    context.subscriptions.push(nonclonelabeldisposable);
}

// this method is called when your extension is deactivated
export function deactivate() { }
