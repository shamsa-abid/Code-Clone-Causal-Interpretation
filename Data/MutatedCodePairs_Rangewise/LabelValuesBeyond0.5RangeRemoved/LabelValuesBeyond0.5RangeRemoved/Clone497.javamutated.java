public class Clone497 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:41514223
*  Stack Overflow answer #:41622251
*  And Stack Overflow answer#:41628357
*/
protected void onCreate (Bundle savedInstanceState) {
super.onCreate (savedInstanceState);
setContentView (R.layout.buttons);
initializeLookup ();
mEditText = (EditText) findViewById (R.id.edit_text);
mHandleInputRunnable = new Runnable () {
@Override
public void run () {
handleAlarmTrigger ();
}}
;
}

protected void onCreate (Bundle savedInstanceState) {
super.onCreate (savedInstanceState);
setContentView (R.layout.activity_main);
Window window = this.getWindow ();
window.addFlags (WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);
window.addFlags (WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED);
window.addFlags (WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);
txtMessage = (TextView) findViewById (R.id.txtMesssage);
}

}