public class Clone983 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:7230819
*  Stack Overflow answer #:19809118
*  And Stack Overflow answer#:10480410
*/
private void transform (XSSFWorkbook workbookOld, HSSFWorkbook workbookNew, XSSFRow rowOld, HSSFRow rowNew) {
{
}

private void transform (HSSFRow rowOld, XSSFRow rowNew) {
if (rowOld.getRowStyle () != null) {
Integer hash = rowOld.getRowStyle ().hashCode ();
if (! this.styleMap.containsKey (hash)) this.transform (hash, rowOld.getRowStyle (), this.workbookNew.createCellStyle ());
rowNew.setRowStyle (this.styleMap.get (hash));
}
{
}
}

}