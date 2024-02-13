public class Clone497 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:41514223
*  Stack Overflow answer #:41622251
*  And Stack Overflow answer#:41628357
*/
protected void onCreate (Bundle savedInstanceState) {
initializeLookup ();
mHandleInputRunnable = new Runnable () {
@Override
public void run () {
handleAlarmTrigger ();
}}
;
}

protected void onCreate (Bundle savedInstanceState) {
Window window = this.getWindow ();
window.addFlags (WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);
window.addFlags (WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED);
window.addFlags (WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);
}

}