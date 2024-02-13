public class AuthorLabel {

    public String fileName;
    public String labeltext;
    public String codeSnippet;
    public int lineStart;
    public int lineEnd;
    public int charStart;
    public int charEnd;
    public String status;
    public double statusNumber;

    public AuthorLabel(String fileName, String labeltext, String codeSnippet, int lineStart, int lineEnd, int charStart, int charEnd, String status) {
        this.fileName = fileName;
        this.labeltext = labeltext;
        this.codeSnippet = codeSnippet;
        this.lineStart = lineStart;
        this.lineEnd = lineEnd;
        this.charStart = charStart;
        this.charEnd = charEnd;
        this.status = status;
        this.statusNumber = this.getStatusNumber(status);
    }


    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getLabeltext() {
        return labeltext;
    }

    public void setLabeltext(String labeltext) {
        this.labeltext = labeltext;
    }

    public String getCodeSnippet() {
        return codeSnippet;
    }

    public void setCodeSnippet(String codeSnippet) {
        this.codeSnippet = codeSnippet;
    }

    public int getLineStart() {
        return lineStart;
    }

    public void setLineStart(int lineStart) {
        this.lineStart = lineStart;
    }

    public int getLineEnd() {
        return lineEnd;
    }

    public void setLineEnd(int lineEnd) {
        this.lineEnd = lineEnd;
    }

    public int getCharStart() {
        return charStart;
    }

    public void setCharStart(int charStart) {
        this.charStart = charStart;
    }

    public int getCharEnd() {
        return charEnd;
    }

    public void setCharEnd(int charEnd) {
        this.charEnd = charEnd;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getStatusNumber(String status) {

        if (status.contentEquals("core-sim") || status.contentEquals("core"))
            return 2;
        if(status.contentEquals("noncore-sim")|| status.contentEquals("noncore"))
            return 1;
        if(status.contentEquals("core-diff") || status.contentEquals("diff"))
            return -2;
        if(status.contentEquals("noncore-diff") || status.contentEquals("noncorediff"))
            return -1;
        return 0;
    }

    public void setStatusNumber(double statusNumber) {
        this.statusNumber = statusNumber;
    }



}
