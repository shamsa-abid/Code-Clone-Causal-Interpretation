public class Clone987 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:7230819
*  Stack Overflow answer #:19809118
*  And Stack Overflow answer#:19809861
*/
private void transform (XSSFWorkbook workbookOld, HSSFWorkbook workbookNew, XSSFRow rowOld, HSSFRow rowNew) {
for (Cell cell : rowOld) {
cellNew = rowNew.createCell (cell.getColumnIndex (), cell.getCellType ());
if (cellNew != null) this.transform (workbookOld, workbookNew, (XSSFCell) cell, cellNew);
}
}

private void transform (HSSFWorkbook workbookOld, XSSFWorkbook workbookNew, HSSFSheet sheetOld, XSSFSheet sheetNew) {
for (Row row : sheetOld) {
rowNew = sheetNew.createRow (row.getRowNum ());
if (rowNew != null) this.transform (workbookOld, workbookNew, (HSSFRow) row, rowNew);
}
(
){
}
(
){
}
}

}