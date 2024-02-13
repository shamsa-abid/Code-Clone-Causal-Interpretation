import * as vscode from 'vscode';
import * as path from 'path';
import * as fs from 'fs';

import { getNotes, saveNotes, Note, getCloneLabels, CloneFile, saveClones } from './note-db';
import { getConfiguration } from './configuration';
import { getRelativePathForFileName,
    getTimeStampsString } from './utils';
import { setDecorations } from './decoration/decoration';
import { log } from 'console';

const getIconPathFromType = (type: string, theme: string): string => {
    return path.join(__filename, '..', '..', 'resources', theme, type.toLowerCase() + '.svg');
};

const getIconPath = (status: string): any => {
    const noteType = (status === 'pending') ? 'note' : 'notedone';
    return {
        light: getIconPathFromType(noteType, 'light'),
        dark: getIconPathFromType(noteType, 'dark')
    };
};

const getContextValue = (status: string): string => {
    return (status === 'pending') ? '$PendingNote' : '$CompleteNote';
};

const getCloneContextValue = (status: string): string => {
    return (status === 'clone') ? '$Clone' : '$NotClone';
};

const createNoteItem = (note: Note): NoteItem => {
    const fullPathFileName = note.fileName;
	const labelStartLine = note.positionStart.line + 1;
	const labelEndLine = note.positionEnd.line + 1;
    let details : NoteItem[] = [];

    if (getConfiguration().showFileName && fullPathFileName.length > 0) {
        // Creates an item under the main note with the File name (if existing)
        const relativePath = getRelativePathForFileName(note.fileName);
        details.push(new NoteItem(`File: ${relativePath} Line: ${labelStartLine}-${labelEndLine}`));
    }
    if (getConfiguration().showCreatedAtTimestamp && note.createdAt) {
        details.push(new NoteItem(`Created at: ${getTimeStampsString(note.createdAt)}`));
    }
    if (getConfiguration().showResolvedAtTimestamp && note.resolvedAt) {
        details.push(new NoteItem(`Resolved at: ${getTimeStampsString(note.resolvedAt)}`));
    }

    let noteItem = new NoteItem(note.text, details, note.id.toString());
    if (noteItem.id) {
        noteItem.command = new OpenNoteCommand(noteItem.id);
    }
    if (details.length > 0) {
        // If details isn't undefined, set the command to the same as the parent
        details[0].command = noteItem.command;
    }
    noteItem.tooltip = note.text;
    noteItem.contextValue = getContextValue(note.status);
    noteItem.iconPath = getIconPath(note.status);

    return noteItem;
};

const createCloneItem = (clone: CloneFile): CloneItem => {
    const fullPathFileName = clone.fileName;
    let details : CloneItem[] = [];

    if (getConfiguration().showFileName && fullPathFileName.length > 0) {
        // Creates an item under the main note with the File name (if existing)
        const relativePath = getRelativePathForFileName(clone.fileName);
        details.push(new CloneItem(`File: ${relativePath}`));
    }
    if (getConfiguration().showCreatedAtTimestamp && clone.createdAt) {
        details.push(new CloneItem(`Created at: ${getTimeStampsString(clone.createdAt)}`));
    }
    if (getConfiguration().showResolvedAtTimestamp && clone.resolvedAt) {
        details.push(new CloneItem(`Resolved at: ${getTimeStampsString(clone.resolvedAt)}`));
    }

    let cloneItem = new CloneItem(clone.text, details, clone.id.toString());
    if (cloneItem.id) {
        cloneItem.command = new OpenCloneCommand(cloneItem.id);
    }
    if (details.length > 0) {
        // If details isn't undefined, set the command to the same as the parent
        details[0].command = cloneItem.command;
    }
    cloneItem.tooltip = clone.text;
    cloneItem.contextValue = getCloneContextValue(clone.status);
    cloneItem.iconPath = getIconPath(clone.status);

    return cloneItem;
};

export class TreeActions {
    constructor(private provider: NotesTree) { }

    removeNote(item: NoteItem) {
        return this.provider.removeItem(item.id);
    }
    // checkNote(item: NoteItem) {
    //     return this.provider.checkItem(item.id, 'done');
    // }
    // uncheckNote(item: NoteItem) {
    //     return this.provider.checkItem(item.id, 'pending');
    // }
    // checkAllNotes(data: any): void {
    //     const children = data.children;
    //     if (!children) { return; }

    //     for (let index = 0; index < children.length; index++) {
    //         const current = children[index];
    //         this.checkNote(current);
    //     }
    // }
    // uncheckAllNotes(data: any): void {
    //     const children = data.children;
		
    //     if (!children) { return; }

    //     for (let index = 0; index < children.length; index++) {
    //         const current = children[index];
    //         this.uncheckNote(current);
    //     }
    // }
    removeAllNotes(data: any): void {
        const children = data.children;
		
        if (!children) { return; }

        for (let index = 0; index < children.length; index++) {
            const current = children[index];
            this.removeNote(current);
        }
    }
    openNote(item: NoteItem) {
        return this.provider.openItem(item.id);
    }
    openNoteFromId(id: string) {
        return this.provider.openItem(id);
    }
    editNote(item: NoteItem) {
        return this.provider.editItem(item.id);
    }
    copyNote(item: NoteItem) {
        return this.provider.copyItem(item.id);
    }
}

export class CloneTreeActions {
    constructor(private provider: ClonesTree) { }

    removeClone(item: CloneItem) {
        return this.provider.removeItem(item.id);
    }
    checkClone(item: CloneItem) {
        return this.provider.checkItem(item.id, 'clone');
    }
    uncheckClone(item: CloneItem) {
        return this.provider.checkItem(item.id, 'notclone');
    }
    // checkAllNotes(data: any): void {
    //     const children = data.children;
    //     if (!children) { return; }

    //     for (let index = 0; index < children.length; index++) {
    //         const current = children[index];
    //         this.checkNote(current);
    //     }
    // }
    // uncheckAllNotes(data: any): void {
    //     const children = data.children;
		
    //     if (!children) { return; }

    //     for (let index = 0; index < children.length; index++) {
    //         const current = children[index];
    //         this.uncheckNote(current);
    //     }
    // }
    // removeAllNotes(data: any): void {
    //     const children = data.children;
		
    //     if (!children) { return; }

    //     for (let index = 0; index < children.length; index++) {
    //         const current = children[index];
    //         this.removeNote(current);
    //     }
    // }
    openCloneFile(item: CloneItem) {
        return this.provider.openItem(item.id);
    }
    openCloneFileFromId(id: string) {
        return this.provider.openItem(id);
    }
    // editNote(item: NoteItem) {
    //     return this.provider.editItem(item.id);
    // }
    // copyNote(item: NoteItem) {
    //     return this.provider.copyItem(item.id);
    // }
}


export class NotesTree implements vscode.TreeDataProvider<NoteItem> {

	private _onDidChangeTreeData: vscode.EventEmitter<NoteItem | undefined | null | void> = new vscode.EventEmitter<NoteItem | undefined | null | void>();
	readonly onDidChangeTreeData: vscode.Event<NoteItem | undefined | null | void> = this._onDidChangeTreeData.event;

	refresh(): void {
	    this.sourceData();
	    this._onDidChangeTreeData.fire(null);
	}

	sourceData(): void {
	    const annotations = getNotes();
		let activeFileName = '';
		// vscode.window.activeTextEditor
		const editor = vscode.window.activeTextEditor;
		if(editor){
			const workspaceFolders = vscode.workspace.workspaceFolders;
    		const workspacePath = workspaceFolders ? workspaceFolders[0].uri.fsPath : '';
    		const filePath = editor.document.uri.fsPath;
    		activeFileName = path.relative(workspacePath, filePath);
		}
		// const clonelabels = getCloneLabels();
	    let countPeding = 0;
	    let countDone = 0;
	    this.data = [];
	    // this.data = [new NoteItem('Pending', undefined, undefined, '$menu-pending'), new NoteItem('Done', undefined, undefined, '$menu-done')];
		this.data = [new NoteItem('-', undefined, undefined, '$menu-pending'), new NoteItem('Labels', undefined, undefined, '$menu-done')];

		for (let note of annotations) {

	        const noteItem = createNoteItem(note);
	        const isPending = note.status === 'pending';
	        if (isPending) {
	            this.data[0].addChild(noteItem);
	            countPeding++;
	        } else {
				if(activeFileName === path.normalize(note.fileName))
				{
					this.data[1].addChild(noteItem);
					countDone++;
				}
	        }

	    }
	    this.data[0].label += ` (${countPeding})`;
	    this.data[1].label += ` (${countDone})`;
	}

	removeItem(id: string | undefined): void {
	    const notes = getNotes();
	    const indexToRemove = notes.findIndex((item: { id: Number }) => {
	        return item.id.toString() === id;
	    });

	    if (indexToRemove >= 0) {
	        notes.splice(indexToRemove, 1);
	    }

	    saveNotes(notes);
	    setDecorations();
	}

	checkItem(id: string | undefined, status: 'pending' | 'done'): void {
	    const notes = getNotes();
	    const index = notes.findIndex((item: { id: Number }) => {
	        return item.id.toString() === id;
	    });

	    if (index >= 0) {
	        notes[index].status = status;
	        const fromDoneToPending = notes[index].resolvedAt && status === 'done';
	        notes[index].resolvedAt =  fromDoneToPending ? undefined : new Date();
	    }

	    saveNotes(notes);
	}

	editItem(id: string | undefined): void {
	    const notes = getNotes();
	    const index = notes.findIndex((item: { id: Number }) => {
	        return item.id.toString() === id;
	    });
			
	    vscode.window.showInputBox({ placeHolder: 'New text for annotation...', value: notes[index].text}).then(annotationText => {
	        if (index >= 0 && annotationText) {
	            notes[index].text = annotationText;
	            saveNotes(notes);
	            vscode.window.showInformationMessage('Annotation edited!');
	        }
	    });
	}

	openItem(id: string | undefined): void {
	    const notes = getNotes();
	    const index = notes.findIndex((item: { id: Number }) => {
	        return item.id.toString() === id;
	    });

	    if (index >= 0) {
	        const note = notes[index];
	        const fileName = note.fileName;
	        const fileLine = note.fileLine;

	        if (fileName.length <= 0) {
	            return;
	        }
			const normalizedPath = path.normalize(fileName);
			const workspaceFolders = vscode.workspace.workspaceFolders;
			const workspacePath = workspaceFolders ? workspaceFolders[0].uri.fsPath : '';
			const newFilePath = path.join(workspacePath, note.fileName);

	        var openPath = vscode.Uri.file(newFilePath);
	        vscode.workspace.openTextDocument(openPath).then(doc => {
	            vscode.window.showTextDocument(doc).then(editor => {
	                var range = new vscode.Range(fileLine, 0, fileLine, 0);
	                editor.revealRange(range);

	                var start = new vscode.Position(note.positionStart.line, note.positionStart.character);
	                var end = new vscode.Position(note.positionEnd.line, note.positionEnd.character);
	                editor.selection = new vscode.Selection(start, end);

	                var range = new vscode.Range(start, start);
	                editor.revealRange(range, vscode.TextEditorRevealType.InCenter);
	            });
	        });
	    }
	}

	copyItem(id: string | undefined): void {
	    const notes = getNotes();
	    const index = notes.findIndex((item: { id: Number }) => {
	        return item.id.toString() === id;
	    });

	    if (index === -1) {
	        return;
	    }

	    const content = notes[index].text;
	    vscode.env.clipboard.writeText(content).then(() => {
	        vscode.window.showInformationMessage('Note copied successfully');
	    });
	}

	data: NoteItem[];

	constructor() {
	    vscode.commands.registerCommand('code-annotation.refreshEntry', () =>
	        this.refresh()
	    );

	    this.data = [];
	    this.sourceData();
	}

	getTreeItem(element: NoteItem): vscode.TreeItem | Thenable<vscode.TreeItem> {
	    return element;
	}

	getChildren(element?: NoteItem | undefined): vscode.ProviderResult<NoteItem[]> {
	    if (element === undefined) {
	        return this.data;
	    }
	    return element.children;
	}
}


export class ClonesTree implements vscode.TreeDataProvider<CloneItem> {

	private _onDidChangeTreeData: vscode.EventEmitter<CloneItem | undefined | null | void> = new vscode.EventEmitter<CloneItem | undefined | null | void>();
	readonly onDidChangeTreeData: vscode.Event<CloneItem | undefined | null | void> = this._onDidChangeTreeData.event;

	refresh(): void {
	    this.sourceData();
	    this._onDidChangeTreeData.fire(null);
	}

	sourceData(): void {
	    // const annotations = getNotes();
		const clonelabels = getCloneLabels();
	    let countClones = 0;
		let countExtClones = 0;
	    let countNotClones = 0;
	    this.data = [];
	    this.data = [new CloneItem('Clones', undefined, undefined, '$menu-clones'),new CloneItem('Clones-Ext', undefined, undefined, '$menu-clones-ext'),new CloneItem('NotClones', undefined, undefined, '$menu-notclones')];
	    for (let clone in clonelabels) {
	        const cloneItem = createCloneItem(clonelabels[clone]);
	        const isClone = clonelabels[clone].status === 'clone';
			const isExtClone = clonelabels[clone].status === 'clone-ext';
			const isNonClone = clonelabels[clone].status === 'notclone';
	        if (isClone) {
	            this.data[0].addChild(cloneItem);
	            countClones++;
	        } 
			if (isExtClone) {
	            this.data[1].addChild(cloneItem);
	            countExtClones++;
	        } 
			if (isNonClone) {
	            this.data[2].addChild(cloneItem);
	            countNotClones++;
	        }
	    }
	    this.data[0].label += ` (${countClones})`;
		this.data[1].label += ` (${countExtClones})`;
	    this.data[2].label += ` (${countNotClones})`;
	}

	removeItem(id: string | undefined): void {
	    const notes = getCloneLabels();
	    const indexToRemove = notes.findIndex((item: { id: Number }) => {
	        return item.id.toString() === id;
	    });

	    if (indexToRemove >= 0) {
	        notes.splice(indexToRemove, 1);
	    }

	    saveClones(notes);
	    // setDecorations();
	}

	checkItem(id: string | undefined, status: 'clone' | 'notclone'): void {
	    const notes = getCloneLabels();
	    const index = notes.findIndex((item: { id: Number }) => {
	        return item.id.toString() === id;
	    });

	    if (index >= 0) {
	        notes[index].status = status;
	        // const fromDoneToPending = notes[index].resolvedAt && status === 'done';
	        // notes[index].resolvedAt =  fromDoneToPending ? undefined : new Date();
	    }

	    saveClones(notes);
	}

	// editItem(id: string | undefined): void {
	//     const notes = getNotes();
	//     const index = notes.findIndex((item: { id: Number }) => {
	//         return item.id.toString() === id;
	//     });
			
	//     vscode.window.showInputBox({ placeHolder: 'New text for annotation...', value: notes[index].text}).then(annotationText => {
	//         if (index >= 0 && annotationText) {
	//             notes[index].text = annotationText;
	//             saveNotes(notes);
	//             vscode.window.showInformationMessage('Annotation edited!');
	//         }
	//     });
	// }

	openItem(id: string | undefined): void {
	    const notes = getCloneLabels();
	    const index = notes.findIndex((item: { id: Number }) => {
	        return item.id.toString() === id;
	    });

	    if (index >= 0) {
	        const note = notes[index];
	        const fileName = note.fileName;
	        // const fileLine = note.fileLine;

	        if (fileName.length <= 0) {
	            return;
	        }
			const normalizedPath = path.normalize(fileName);
			const workspaceFolders = vscode.workspace.workspaceFolders;
			const workspacePath = workspaceFolders ? workspaceFolders[0].uri.fsPath : '';
			const newFilePath = path.join(workspacePath, fileName);
	        var openPath = vscode.Uri.file(newFilePath);
	        vscode.workspace.openTextDocument(openPath).then(doc => {
	            vscode.window.showTextDocument(doc).then(editor => {
	                // var range = new vscode.Range(fileLine, 0, fileLine, 0);
	                // editor.revealRange(range);

	                // var start = new vscode.Position(note.positionStart.line, note.positionStart.character);
	                // var end = new vscode.Position(note.positionEnd.line, note.positionEnd.character);
	                // editor.selection = new vscode.Selection(start, end);

	                // var range = new vscode.Range(start, start);
	                // editor.revealRange(range, vscode.TextEditorRevealType.InCenter);
	            });
	        });
	    }
	}

	// copyItem(id: string | undefined): void {
	//     const notes = getNotes();
	//     const index = notes.findIndex((item: { id: Number }) => {
	//         return item.id.toString() === id;
	//     });

	//     if (index === -1) {
	//         return;
	//     }

	//     const content = notes[index].text;
	//     vscode.env.clipboard.writeText(content).then(() => {
	//         vscode.window.showInformationMessage('Note copied successfully');
	//     });
	// }

	data: CloneItem[];

	constructor() {
	    vscode.commands.registerCommand('clone-annotation.refreshEntry', () =>
	        this.refresh()
	    );

	    this.data = [];
	    this.sourceData();
	}

	getTreeItem(element: CloneItem): vscode.TreeItem | Thenable<vscode.TreeItem> {
	    return element;
	}

	getChildren(element?: CloneItem | undefined): vscode.ProviderResult<CloneItem[]> {
	    if (element === undefined) {
	        return this.data;
	    }
	    return element.children;
	}
}

class OpenNoteCommand implements vscode.Command {
	command = 'code-annotation.openNoteFromId';
	title = 'Open File';
	arguments?: any[];

	constructor(id: string) {
	    this.arguments = [id];
	}
}

class OpenCloneCommand implements vscode.Command {
	command = 'clone-annotation.openCloneFromId';
	title = 'Open File';
	arguments?: any[];

	constructor(id: string) {
	    this.arguments = [id];
	}
}

class NoteItem extends vscode.TreeItem {
	children: NoteItem[] | undefined;

	constructor(label: string, children?: NoteItem[] | undefined, noteId?: string | undefined, context?: string | undefined) {
	    super(
	        label,
	        children === undefined ? vscode.TreeItemCollapsibleState.None :
	            vscode.TreeItemCollapsibleState.Expanded);
	    this.children = children;
	    if (noteId) {
	        this.id = noteId;
	    }
	    if (context) {
	        this.contextValue = context;
	    }
	}

	addChild(element: NoteItem) {
	    if (this.children === undefined) {
	        this.children = [];
	        this.collapsibleState = vscode.TreeItemCollapsibleState.Expanded;
	    }
	    this.children.push(element);
	}
}


class CloneItem extends vscode.TreeItem {
	children: CloneItem[] | undefined;

	constructor(label: string, children?: CloneItem[] | undefined, cloneId?: string | undefined, context?: string | undefined) {
	    super(
	        label,
	        children === undefined ? vscode.TreeItemCollapsibleState.None :
	            vscode.TreeItemCollapsibleState.Expanded);
	    this.children = children;
	    if (cloneId) {
	        this.id = cloneId;
	    }
	    if (context) {
	        this.contextValue = context;
	    }
	}

	addChild(element: CloneItem) {
	    if (this.children === undefined) {
	        this.children = [];
	        this.collapsibleState = vscode.TreeItemCollapsibleState.Expanded;
	    }
	    this.children.push(element);
	}
}
