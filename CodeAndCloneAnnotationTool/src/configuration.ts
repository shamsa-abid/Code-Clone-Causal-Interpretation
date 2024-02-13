import * as vscode from 'vscode';
import * as path from 'path';
import * as fs from 'fs';

let storageLocation : string = '';
const annotationFile : string = 'annotationsdb.json';
const clonelabelsFile : string = 'clonelabelsdb.json';

const codelabelsFile : string = 'codelabels.json';
const clonelabelscsvFile : string = 'clonelabels.csv';

export const getAnnotationFilePath = (): string => {
    return path.join(storageLocation, annotationFile);
};

export const getCloneLabelsFilePath = (): string => {
    return path.join(storageLocation, clonelabelsFile);
};

export const getCodeLabelsJsonFilePath = (): string => {
    return path.join(storageLocation, codelabelsFile);
};

export const getCloneLabelsCSVFilePath = (): string => {
    return path.join(storageLocation, clonelabelscsvFile);
};
export const initializeStorageLocation = (location: string) => {
    if (location) {
        storageLocation = location;
        if (!fs.existsSync(storageLocation)) {
            fs.mkdirSync(storageLocation, { recursive: true });
        }
        const extensionFilePath = getAnnotationFilePath();
        if (!fs.existsSync(extensionFilePath)) {
            fs.writeFileSync(extensionFilePath, '{"notes":[], "nextId":1}');
        }
        const cloneFilePath = getCloneLabelsFilePath();
        if (!fs.existsSync(cloneFilePath)) {
            fs.writeFileSync(cloneFilePath, '{"clones":[], "nextId":1}');
        }
    } else {
	  	throw new Error('Error loading Storage for Extension');
    }
};


export interface Color {
    dark: string,
    light: string,
    core: string,
    noncore: string,
    diff: string,
    noncorediff: string,
    lightcore: string,
    lightnoncore: string,
    lightdiff: string,
    lightnoncorediff: string
}

export interface Configuration {
    showFileName: boolean;
    showCreatedAtTimestamp: boolean;
    showResolvedAtTimestamp: boolean;
    customTODO: string[];
    enableDecoration: boolean;
    decorationColors: Color;
    filespathtosavefiles: string;
}

export const getConfiguration = (): Configuration => {
    const configuration = vscode.workspace.getConfiguration('code-annotation');
    const showFileName : boolean = configuration.get('showFileName') || false;
    const showCreatedAtTimestamp : boolean = configuration.get('showTimeStampForNoteCreation') || false;
    const showResolvedAtTimestamp : boolean = configuration.get('showTimeStampForNoteResolution') || false;
    const customTODO: string[] = configuration.get('customTODO') || [];
    const enableDecoration : boolean = configuration.get('annotationBG.enableDecoration') || false;
    const decorationDarkColor: string = configuration.get('annotationBG.color.dark') || '';
    const decorationCoreColor: string = configuration.get('annotationBG.color.core') || '';
    const decorationNonCoreColor: string = configuration.get('annotationBG.color.noncore') || '';
    const decorationDiffColor: string = configuration.get('annotationBG.color.diff') || '';
    const decorationNoncoreDiffColor: string = configuration.get('annotationBG.color.noncorediff') || '';
    const decorationLightColor: string = configuration.get('annotationBG.color.light') || '';
    const decorationLightCoreColor: string = configuration.get('annotationBG.color.lightcore') || '';
    const decorationLightNonCoreColor: string = configuration.get('annotationBG.color.lightnoncore') || '';
    const decorationLightDiffColor: string = configuration.get('annotationBG.color.lightdiff') || '';
    const decorationLightNoncoreDiffColor: string = configuration.get('annotationBG.color.lightnoncorediff') || '';
    const filespathtosavefiles: string = configuration.get('filespath') || '';
    const config: Configuration = {
        showFileName: showFileName,
        showCreatedAtTimestamp: showCreatedAtTimestamp,
        showResolvedAtTimestamp: showResolvedAtTimestamp,
        customTODO: customTODO,
        enableDecoration: enableDecoration,
        decorationColors: {
            dark: decorationDarkColor,
            light: decorationLightColor,
            core: decorationCoreColor,
            noncore:decorationNonCoreColor,
            diff:decorationDiffColor,
            noncorediff:decorationNoncoreDiffColor,
            lightcore: decorationLightCoreColor,
            lightnoncore:decorationLightNonCoreColor,
            lightdiff:decorationLightDiffColor,
            lightnoncorediff:decorationLightNoncoreDiffColor
        },
        filespathtosavefiles: filespathtosavefiles
    };

    return config;
};

