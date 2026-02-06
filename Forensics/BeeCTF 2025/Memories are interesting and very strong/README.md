Mr. Udin is a very paranoid person — he keeps all his passwords inside a KeePass database. One day, in an attempt to make his master password safer, he encrypted it with a custom algorithm. But just as he was entering the key, his computer suddenly crashed.

Now the key is gone, and Mr. Udin needs your help to recover it. Can you figure it out?

One last thing, Mr. Udin really loves the band Radiohead, so perhaps the key has a reference to them...

download link : https://binusianorg-my.sharepoint.com/personal/owen_bong_binus_ac_id/_layouts/15/guestaccess.aspx?share=Ed-mfzAByzxMuHshcIQ-1FABHAEBu8iPhwzxvf4OOPoMkg&e=G6aXc1 password : f5cc7a3587b183ca7bbb6973c014be6e author: wavess

View Hint: hint 1 (Cost: 0 points)

Ada 3 proses berjalan yang patut untuk diperhatikan. Total file yang harus didump untuk soal ini adalah 4 file. Tinggal ikutin flownya saja dari 3 proses tersebut.

View Hint: hint 2

Key untuk encryption diketik di notepad yang sesuai di soal ngecrash. Tinggal di grep aja dengan cara yang benar. Untuk encryption menggunakan AES-CTR. Hasil decryption digunakan untuk membuka file keepass.

## Solution

- `vol -f chall pslist`:
```
PID	PPID	ImageFileName	Offset(V)	Threads	Handles	SessionId	Wow64	CreateTime	ExitTime	File output
---------------------------------------------------------snip---------------------------------------------------------
4116	736	svchost.exe	0x848f1e4c50c0	1	-	0	False	2025-09-16 08:02:19.000000 UTC	N/A	Disabled
6108	736	svchost.exe	0x848f1ceb9340	0	-	0	False	2025-09-16 08:02:28.000000 UTC	2025-09-16 08:02:35.000000 UTC	Disabled
6276	736	svchost.exe	0x848f1cce7340	6	-	0	False	2025-09-16 08:03:16.000000 UTC	N/A	Disabled
5592	4928	powershell.exe	0x848f1bc6b2c0	11	-	1	False	2025-09-16 08:03:23.000000 UTC	N/A	Disabled
2244	5592	conhost.exe	0x848f15fa02c0	5	-	1	False	2025-09-16 08:03:24.000000 UTC	N/A	Disabled
3368	876	WmiPrvSE.exe	0x848f1c7f4080	5	-	0	False	2025-09-16 08:03:26.000000 UTC	N/A	Disabled
5132	4928	KeePass.exe	0x848f15dec340	4	-	1	False	2025-09-16 08:05:41.000000 UTC	N/A	Disabled
6928	3600	SearchProtocol	0x848f1c64f340	4	-	1	False	2025-09-16 08:07:20.000000 UTC	N/A	Disabled
1732	876	RuntimeBroker.	0x848f1d0c8080	6	-	1	False	2025-09-16 08:07:36.000000 UTC	N/A	Disabled
2968	2344	audiodg.exe	0x848f1c7ca2c0	3	-	0	False	2025-09-16 08:07:37.000000 UTC	N/A	Disabled
7480	736	svchost.exe	0x848f1c342080	5	-	0	False	2025-09-16 08:08:06.000000 UTC	N/A	Disabled
5724	736	VSSVC.exe	0x848f1d0d4340	6	-	0	False	2025-09-16 08:08:07.000000 UTC	N/A	Disabled
7232	736	svchost.exe	0x848f160ec080	6	-	0	False	2025-09-16 08:08:07.000000 UTC	N/A	Disabled
2444	736	svchost.exe	0x848f1bcf0300	10	-	0	False	2025-09-16 08:08:07.000000 UTC	N/A	Disabled
6760	4928	notepad.exe	0x848f1d3de080	4	-	1	False	2025-09-16 08:08:50.000000 UTC	N/A	Disabled
7292	3196	MpCmdRun.exe	0x848f15feb080	9	-	0	False	2025-09-16 08:09:42.000000 UTC	N/A	Disabled
---------------------------------------------------------snip---------------------------------------------------------
```

- `vol -f chall windows.cmdline`:

```
PID	Process	Args
---------------------------------------------------------snip---------------------------------------------------------
6276	svchost.exe	C:\Windows\system32\svchost.exe -k LocalServiceAndNoImpersonation -p -s SSDPSRV
5592	powershell.exe	"C:\Windows\System32\WindowsPowerShell\v1.0\powershell.exe" 
2244	conhost.exe	\??\C:\Windows\system32\conhost.exe 0x4
3368	WmiPrvSE.exe	C:\Windows\system32\wbem\wmiprvse.exe
5132	KeePass.exe	"C:\Program Files\KeePass Password Safe 2\KeePass.exe" "C:\Users\wavess\Documents\allmypasswords.kdbx"
6928	SearchProtocol	"C:\Windows\system32\SearchProtocolHost.exe" Global\UsGthrFltPipeMssGthrPipe_S-1-5-21-3914000753-1211837437-3574760-10013_ Global\UsGthrCtrlFltPipeMssGthrPipe_S-1-5-21-3914000753-1211837437-3574760-10013 1 -2147483646 "Software\Microsoft\Windows Search" "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT; MS Search 4.0 Robot)" "C:\ProgramData\Microsoft\Search\Data\Temp\usgthrsvc" "DownLevelDaemon"  "1"
1732	RuntimeBroker.	C:\Windows\System32\RuntimeBroker.exe -Embedding
2968	audiodg.exe	C:\Windows\system32\AUDIODG.EXE 0x488
7480	svchost.exe	C:\Windows\System32\svchost.exe -k WerSvcGroup
5724	VSSVC.exe	C:\Windows\system32\vssvc.exe
7232	svchost.exe	C:\Windows\System32\svchost.exe -k swprv
2444	svchost.exe	C:\Windows\system32\svchost.exe -k netsvcs -p -s wlidsvc
6760	notepad.exe	"C:\Windows\system32\notepad.exe" 
7292	MpCmdRun.exe	"C:\ProgramData\Microsoft\Windows Defender\platform\4.18.25070.5-0\MpCmdRun.exe" SignatureUpdate -ScheduleJob -RestrictPrivileges
---------------------------------------------------------snip---------------------------------------------------------
```

- `vol -f chall windows.filescan >files.txt`

```
Offset	Name
---------------------------------------------------------snip---------------------------------------------------------
0x848f1fb68850	\Windows\CbsTemp\31205088_453359612\Windows10.0-KB5065429-x64.cab\$dpx$.tmp\e531529ae0f7c1419e4ad528d5d60591.tmp
0x848f1fb689e0	\Windows\CbsTemp\31205088_453359612\Windows10.0-KB5065429-x64.cab\$dpx$.tmp\80bab3627ec7dd47bcc972e0cbfafaf1.tmp
0x848f1fb68b70	\Users\wavess\AppData\Roaming\Microsoft\Windows\PowerShell\PSReadLine\ConsoleHost_history.txt
0x848f1fb68d00	\Windows\CbsTemp\31205088_453359612\Windows10.0-KB5065429-x64.cab\$dpx$.tmp\337495084c1d6540a71d5e3f4ac49806.tmp
0x848f1fb68e90	\Windows\CbsTemp\31205088_453359612\Windows10.0-KB5065429-x64.cab\$dpx$.tmp\7577250155a31f48b276953c6db800f5.tmp
---------------------------------------------------------snip---------------------------------------------------------
```

It's known that file above (`ConsoleHost_history.txt`) contains the command history of PowerShell.
We can dump it:

- `vol -f chall windows.dumpfiles --virtaddr 0x848f1fb68b70`

```
$ cat file.0x848f1fb68b70.0x848f1a3d5110.DataSectionObject.ConsoleHost_history.txt.dat
ls
mv encrypt.ps1 ..\AppData\Local\D3DSCache\45a5e5b635b28e7a\
.\encyrpt.ps1
ls
pwd
whoami
uuid
id
semoga bisa solve temen tmeen
BEECTF
whoami
echo "BEECTF{not_the_flag_dont_submit}"ls
file .\thisisimportant.enc
cat .\thisisimportant.enc
cd .\Desktop\
cat .\thisisimportant.enc.enc
```

So there's `encrypt.ps1`. We can look again at `files.txt`, and there's it is:

```
0x848f1e03b710	\Users\wavess\AppData\Local\D3DSCache\45a5e5b635b28e7a\encyrpt.ps1
```

- `vol -f chall windows.dumpfiles --virtaddr 0x848f1e03b710`

```
$ cat ./file.0x848f1e03b710.0x848f23456c90.DataSectionObject.encyrpt.ps1.dat
Add-Type -AssemblyName System.Security
$key = [Text.Encoding]::UTF8.GetBytes("REDACTED")
$iv = [Text.Encoding]::UTF8.GetBytes("REDACTED")
$desktop = [Environment]::GetFolderPath("Desktop")
$inPath = Join-Path $desktop "thisisimportant.txt"
$outPath = Join-Path $desktop "thisisimportant.enc"
$plaintext = [System.IO.File]::ReadAllBytes($inPath)
$aes = [System.Security.Cryptography.AesManaged]::new()
$aes.Mode = [System.Security.Cryptography.CipherMode]::ECB
$aes.Padding = [System.Security.Cryptography.PaddingMode]::None
$encryptor = $aes.CreateEncryptor($key, (New-Object byte[] ($aes.BlockSize/8)))
$counter = $iv.Clone()
$encrypted = New-Object byte[] $plaintext.Length
for ($i=0; $i -lt $plaintext.Length; $i+=$aes.BlockSize/8) {
    $block = New-Object byte[] ($aes.BlockSize/8)
    $encryptor.TransformBlock($counter,0,$counter.Length,$block,0) | Out-Null
    for ($j=0; $j -lt ($aes.BlockSize/8) -and ($i+$j) -lt $plaintext.Length; $j++) {
        $encrypted[$i+$j] = $plaintext[$i+$j] -bxor $block[$j]
    }
    for ($k=$counter.Length-1; $k -ge 0; $k--) {
        if (++$counter[$k] -ne 0) { break }
    }
}
$base64 = [Convert]::ToBase64String($encrypted)
[System.IO.File]::WriteAllText($outPath, $base64)
```

This is AES-CTR basically. We need the key and IV now.
But in the meantime, let's get the encrypted file first.

```
0x848f1c39b9e0	\Users\wavess\Desktop\thisisimportant.enc.enc
```

- `vol -f chall windows.dumpfiles --virtaddr 0x848f1c39b9e0`

```
$ cat file.0x848f1c39b9e0.0x848f1ea3f450.DataSectionObject.thisisimportant.enc.enc.dat
MDEwMWQ4ZTA1MTIwYWYwNzdkNDA4ZjA5ZTA0ODYxZmZmMjZhNWE2YTYyZjQxMzU3ZmRjYg==
```

Since Notepad crashed before the key and IV can be saved, it should be in memory.

- `vol -f chall windows.memmap --pid 6760 --dump`

```
$ strings --encoding=l pid.6760.dmp | rg 'radiohead'
key is radioheadisgreat, while iv is goodjobgettingit
key is radioheadisgreat, while iv is goodjobgettingit
$key = [Text.Encoding]::UTF8.GetBytes("radioheadisgreat")
$key = [Text.Encoding]::UTF8.GetBytes("radioheadisgreat")
$key = [Text.Encoding]::UTF8.GetBytes("radioheadisgreat")
$key = [Text.Encoding]::UTF8.GetBytes("radioheadisgreat")
key is radioheadisgreat, while iv is goodjobgettingit
```

That's all needed, so I decrypted it in [Cyberchef](https://gchq.github.io/CyberChef/#recipe=From_Base64('A-Za-z0-9%2B/%3D',true,false)AES_Decrypt(%7B'option':'UTF8','string':'radioheadisgreat'%7D,%7B'option':'UTF8','string':'goodjobgettingit'%7D,'CTR','Hex','Raw',%7B'option':'Hex','string':''%7D,%7B'option':'Hex','string':''%7D)&input=TURFd01XUTRaVEExTVRJd1lXWXdOemRrTkRBNFpqQTVaVEEwT0RZeFptWm1NalpoTldFMllUWXlaalF4TXpVM1ptUmpZZz09).
What I got is `BEECTF{memory_is_a_strong_`. That's part of the flag!
Remember that there's the Keepass database we haven't touched on yet.
That part of the flag is actually the password for the database.
The database file name can be seen in the command line analysis above.
`0x848f1e019750	\Users\wavess\Documents\allmypasswords.kdbx`.

- `vol -f chall windows.dumpfiles --virtaddr 0x848f1e019750`

I then opened the database with [Keeweb](https://app.keeweb.info/), used the password, and find this `Yayugotit` entry.
The password for that entry is `thing_to_analyze_4fb7d3a}`,
so the flag is: `BEECTF{memory_is_a_strong_thing_to_analyze_4fb7d3a}`
