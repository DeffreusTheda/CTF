**scp** - secure copy (remote file copy program)

scp copies files between hosts on a [[Network]]. It uses [[ssh]](1) for data transfer, and uses the same authentication and provides the same security as [[ssh]](1). Unlike [[rcp]](1), [[scp]] will ask for passwords or passphrases if they are needed for authentication.

[[File]] names may contain a user and host specification to indicate that the file is to be copied to/from that host. Local file names can be made explicit using absolute or relative pathnames to avoid scp treating file names containing ':' as host specifiers. Copies between two remote hosts are also permitted.

When copying a source file to a target file which already exists, [[scp]] will replace the contents of the target file (keeping the [[Inode]]).

If the target file does not yet exist, an empty file with the target file name is created, then filled with the source file contents. No attempt is made at "near-atomic" transfer using temporary files.
