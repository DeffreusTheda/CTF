>`$ jadx`<br>
>see around<br>
>sources/binus/beectf/portal*<br>
>see `EncUtils.encryptPassword(LoginActivity.this, obj2).equals("tQsCnPDSC6Uy9iNIDN04XQ6b1QOLc9AmidT1rjM8WfI="` @ LoginActivity.java<br>
>"ah yes, AES again"<br>
>don't know `R.string.keystore`<br>
>`$ rg keystore` at great-grandparent dirs<br>
>`resources/res/values/strings.xml 51:    <string name="keystore">Keyfrombeekeyper</string>`<br>
>"cool"<br>
>at this point I'm making a `Solve.java`<br>
>`$ java Solve`<br>
>`praise_the_queen`<br>