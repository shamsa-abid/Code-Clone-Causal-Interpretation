public class Clone988 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:7230819
*  Stack Overflow answer #:19809118
*  And Stack Overflow answer#:19809861
*/
private void transform (XSSFWorkbook workbookOld, HSSFWorkbook workbookNew, XSSFRow rowOld, HSSFRow rowNew) {
HSSFCell cellNew;
rowNew.setHeight (rowOld.getHeight ());
for (Cell cell : rowOld) {
cellNew = rowNew.createCell (cell.getColumnIndex ());
}
this.lastColumn = Math.max (this.lastColumn, rowOld.getLastCellNum ());
}

private void transform (HSSFWorkbook workbookOld, XSSFWorkbook workbookNew, HSSFCell cellOld, XSSFCell cellNew) {
cellNew.setCellComment (cellOld.getCellComment ());
Integer hash = cellOld.getCellStyle ().hashCode ();
if (this.styleMap != null && ! this.styleMap.containsKey (hash)) {
this.transform (workbookOld, hash, cellOld.getCellStyle (), (XSSFCellStyle) workbookNew.createCellStyle ());
}
cellNew.setCellStyle (this.styleMap.get (hash));
case Cell.CELL_TYPE_BLANK :
break;
case Cell.CELL_TYPE_BOOLEAN :
cellNew.setCellValue (cellOld.getBooleanCellValue ());
break;
case Cell.CELL_TYPE_ERROR :
cellNew.setCellValue (cellOld.getErrorCellValue ());
break;
case Cell.CELL_TYPE_FORMULA :
cellNew.setCellValue (cellOld.getCellFormula ());
break;
case Cell.CELL_TYPE_NUMERIC :
cellNew.setCellValue (cellOld.getNumericCellValue ());
break;
case Cell.CELL_TYPE_STRING :
cellNew.setCellValue (cellOld.getStringCellValue ());
break;
default :
System.out.println ("transform: Unbekannter Zellentyp ");
}
}

}