# Serial Key Writeup by Deffreus - CompfestCTF 16

###### Author: Zanark

## Description

Classic reverse, classic serial key
nc challenges.ctf.compfest.id 20012

[soal](https://ctf.compfest.id/files/57a7c62d03afd184d35f7d0e7cb887a2/soal?token=eyJ1c2VyX2lkIjo3MiwidGVhbV9pZCI6MzA3LCJmaWxlX2lkIjo0MH0.Zq9Jdg.a7jyaxs8oWnTANglff1Ya_ixy-s)

## Files

```
$ file soal 
soal: ELF 64-bit LSB pie executable, x86-64, version 1 (SYSV), dynamically linked, interpreter /lib64/ld-linux-x86-64.so.2, BuildID[sha1]=d593229ad5292f597dc844e788f0e38e48ec5d7e, for GNU/Linux 3.2.0, not stripped
$ ls -lh soal 
-rw-r--r-- 1 vinnie vinnie 17K Aug  2 16:46 soal
```

## Solution

I've Decompiled the binary using Hex-Rays.
This is the main function:

```soal.c
int main(int argc, const char **argv, const char **envp) {
  char v6[32];
  char v7[104];

  setvbuf(stdout, 0LL, 2, 0LL);
  for ( int i = 0; i <= 99; ++i ) {
    printf("Serial %d ==> ", (unsigned int)(i + 1));
    __isoc99_scanf("%s", v6);
    if ( !(unsigned int)check((long long)v6) ) {
      puts("Salah");
      return 0;
    }
  }
  FILE *v5 = fopen("flag.txt", "r");
  __isoc99_fscanf(v5, "%s", v7);
  printf("%s", v7);
  return 0;
}
```

It asks for 100 serial key, and perform `check` function on each of it.
If any of the check fails, then we will not get the flag.
Here's what `check` looks like:

```soal.c
long long check(long long a1) {
  char *s1[6];
  char s2[4];

  if ( strlen((const char *)a1) != 24 )
    return 0LL;
  for ( int i = 4; i <= 23; i += 5 )
    if ( *(_BYTE *)(i + a1) != 45 )
      return 0LL;
  if ( *(_BYTE *)(a1 + 10) != 67 )
    return 0LL;
  if ( *(_BYTE *)(a1 + 11) != 70 )
    return 0LL;
  if ( *(_BYTE *)(a1 + 12) != 49 )
    return 0LL;
  if ( *(_BYTE *)(a1 + 13) != 54 )
    return 0LL;
  for ( int i = 0; i < idx; ++i ) {
    if ( !strncmp(*((const char **)&serial + i), (const char *)a1, 0x18uLL) )
      return 0LL;
  }
  for ( int i = 0; i <= 23; i += 5 ) { // 0 5 10 15 20
    for ( int j = i; j <= i + 3; ++j ) {
      int v9 = *(char *)(j + a1);
      if ( (v9 <= 47 || v9 > 57) && (v9 <= 64 || v9 > 90) )
        return 0LL;
    }
    s2[0] = *(_BYTE *)(i + a1);
    s2[1] = *(_BYTE *)(i + 1LL + a1);
    s2[2] = *(_BYTE *)(i + 2LL + a1);
    s2[3] = *(_BYTE *)(i + 3LL + a1);
    for ( int j = 0; j < i / 5; ++j )
      if ( !strncmp(s1[j], s2, 4uLL) )
        return 0LL;
    s1[i / 5] = (char *)malloc(4uLL);
    s1[i / 5] = strdup(s2);
  }
  *((_QWORD *)&serial + idx) = malloc(0x18uLL);
  *((_QWORD *)&serial + idx) = strdup((const char *)a1);
  ++idx;
  return 1LL;
}
```

If the code below evaluate to true, then the checks return false.
Based on each conditions, we can gain clues about the flag. Let's do this step by step:

```soal.c
  if ( strlen((const char *)a1) != 24 )
    return 0LL;
```

Flag is 24 character long: `                        `.

```soal.c
  for ( int i = 4; i <= 23; i += 5 )
    if ( *(_BYTE *)(i + a1) != 45 ) // 45 -> '-'
      return 0LL;
```

The 5th, 10th, 15th, and 20th character is `-`: `    -    -    -    -    `
Basically, the serial key is divided into 5 with `-` as delimiter.
Let's call one part of that as nibble from here on.

```soal.c
  if ( *(_BYTE *)(a1 + 10) != 67 )
    return 0LL;
  if ( *(_BYTE *)(a1 + 11) != 70 )
    return 0LL;
  if ( *(_BYTE *)(a1 + 12) != 49 )
    return 0LL;
  if ( *(_BYTE *)(a1 + 13) != 54 )
    return 0LL;
```

The 11th till 14th character is "CF16": `    -    -CF16-    -    `
So, we know that the middle nibble is `CF16`.

```soal.c
  for ( int i = 0; i <= 23; i += 5 )
    for ( int j = i; j <= i + 3; ++j ) {
      int v9 = *(char *)(j + a1);
      if ( (v9 <= 47 || v9 > 57) && (v9 <= 64 || v9 > 90) )
        return 0LL;
    }
```

`47 < v9 <= 57, 64 < v9 <= 90`, or ` '0' < v9 <= '9', 'A' < v9 <= 'Z'` -> The flag character must be either a number or capital letter, except the `-` characters.

```soal.c
  for ( int i = 0; i <= 23; i += 5 ) {
    s2[0] = *(_BYTE *)(i + a1);
    s2[1] = *(_BYTE *)(i + 1LL + a1);
    s2[2] = *(_BYTE *)(i + 2LL + a1);
    s2[3] = *(_BYTE *)(i + 3LL + a1);
    for ( j = 0; j < i / 5; ++j ) {
      if ( !strncmp(s1[j], s2, 4uLL) )
        return 0LL;
    }
    s1[i / 5] = (char *)malloc(4uLL);
    s1[i / 5] = strdup(s2);
  }
```

This code make sure that there's no duplicate nibble in the serial key.
`malloc` is used here to retain previous serial keys.
If there's any duplicate serial key, the `strncmp` would return a fail.

That's all for check, so we just need to make unique 100 serial keys affirming to the conditions said above.
Here's mine:

```keys.txt
1111-1112-CF16-1113-1114
1115-1116-CF16-1117-1118
1119-1120-CF16-1121-1122
1123-1124-CF16-1125-1126
1127-1128-CF16-1129-1130
1131-1132-CF16-1133-1134
1135-1136-CF16-1137-1138
1139-1140-CF16-1141-1142
1143-1144-CF16-1145-1146
1147-1148-CF16-1149-1150
1151-1152-CF16-1153-1154
1155-1156-CF16-1157-1158
1159-1160-CF16-1161-1162
1163-1164-CF16-1165-1166
1167-1168-CF16-1169-1170
1171-1172-CF16-1173-1174
1175-1176-CF16-1177-1178
1179-1180-CF16-1181-1182
1183-1184-CF16-1185-1186
1187-1188-CF16-1189-1190
1191-1192-CF16-1193-1194
1195-1196-CF16-1197-1198
1199-1200-CF16-1201-1202
1203-1204-CF16-1205-1206
1207-1208-CF16-1209-1210
1211-1212-CF16-1213-1214
1215-1216-CF16-1217-1218
1219-1220-CF16-1221-1222
1223-1224-CF16-1225-1226
1227-1228-CF16-1229-1230
1231-1232-CF16-1233-1234
1235-1236-CF16-1237-1238
1239-1240-CF16-1241-1242
1243-1244-CF16-1245-1246
1247-1248-CF16-1249-1250
1251-1252-CF16-1253-1254
1255-1256-CF16-1257-1258
1259-1260-CF16-1261-1262
1263-1264-CF16-1265-1266
1267-1268-CF16-1269-1270
1271-1272-CF16-1273-1274
1275-1276-CF16-1277-1278
1279-1280-CF16-1281-1282
1283-1284-CF16-1285-1286
1287-1288-CF16-1289-1290
1291-1292-CF16-1293-1294
1295-1296-CF16-1297-1298
1299-1300-CF16-1301-1302
1303-1304-CF16-1305-1306
1307-1308-CF16-1309-1310
1311-1312-CF16-1313-1314
1315-1316-CF16-1317-1318
1319-1320-CF16-1321-1322
1323-1324-CF16-1325-1326
1327-1328-CF16-1329-1330
1331-1332-CF16-1333-1334
1335-1336-CF16-1337-1338
1339-1340-CF16-1341-1342
1343-1344-CF16-1345-1346
1347-1348-CF16-1349-1350
1351-1352-CF16-1353-1354
1355-1356-CF16-1357-1358
1359-1360-CF16-1361-1362
1363-1364-CF16-1365-1366
1367-1368-CF16-1369-1370
1371-1372-CF16-1373-1374
1375-1376-CF16-1377-1378
1379-1380-CF16-1381-1382
1383-1384-CF16-1385-1386
1387-1388-CF16-1389-1390
1391-1392-CF16-1393-1394
1395-1396-CF16-1397-1398
1399-1400-CF16-1401-1402
1403-1404-CF16-1405-1406
1407-1408-CF16-1409-1410
1411-1412-CF16-1413-1414
1415-1416-CF16-1417-1418
1419-1420-CF16-1421-1422
1423-1424-CF16-1425-1426
1427-1428-CF16-1429-1430
1431-1432-CF16-1433-1434
1435-1436-CF16-1437-1438
1439-1440-CF16-1441-1442
1443-1444-CF16-1445-1446
1447-1448-CF16-1449-1450
1451-1452-CF16-1453-1454
1455-1456-CF16-1457-1458
1459-1460-CF16-1461-1462
1463-1464-CF16-1465-1466
1467-1468-CF16-1469-1470
1471-1472-CF16-1473-1474
1475-1476-CF16-1477-1478
1479-1480-CF16-1481-1482
1483-1484-CF16-1485-1486
1487-1488-CF16-1489-1490
1491-1492-CF16-1493-1494
1495-1496-CF16-1497-1498
1499-1500-CF16-1501-1502
1503-1504-CF16-1505-1506
1507-1508-CF16-1509-1510
```

Now, let's do this on the actual server instance.

```
$ nc challenges.ctf.compfest.id 20012 < keys.txt
Serial 1 ==> Serial 2 ==> Serial 3 ==> Serial 4 ==> Serial 5 ==> Serial 6 ==> Serial 7 ==> Serial 8 ==> Serial 9 ==> Serial 10 ==> Serial 11 ==> Serial 12 ==> Serial 13 ==> Serial 14 ==> Serial 15 ==> Serial 16 ==> Serial 17 ==> Serial 18 ==> Serial 19 ==> Serial 20 ==> Serial 21 ==> Serial 22 ==> Serial 23 ==> Serial 24 ==> Serial 25 ==> Serial 26 ==> Serial 27 ==> Serial 28 ==> Serial 29 ==> Serial 30 ==> Serial 31 ==> Serial 32 ==> Serial 33 ==> Serial 34 ==> Serial 35 ==> Serial 36 ==> Serial 37 ==> Serial 38 ==> Serial 39 ==> Serial 40 ==> Serial 41 ==> Serial 42 ==> Serial 43 ==> Serial 44 ==> Serial 45 ==> Serial 46 ==> Serial 47 ==> Serial 48 ==> Serial 49 ==> Serial 50 ==> Serial 51 ==> Serial 52 ==> Serial 53 ==> Serial 54 ==> Serial 55 ==> Serial 56 ==> Serial 57 ==> Serial 58 ==> Serial 59 ==> Serial 60 ==> Serial 61 ==> Serial 62 ==> Serial 63 ==> Serial 64 ==> Serial 65 ==> Serial 66 ==> Serial 67 ==> Serial 68 ==> Serial 69 ==> Serial 70 ==> Serial 71 ==> Serial 72 ==> Serial 73 ==> Serial 74 ==> Serial 75 ==> Serial 76 ==> Serial 77 ==> Serial 78 ==> Serial 79 ==> Serial 80 ==> Serial 81 ==> Serial 82 ==> Serial 83 ==> Serial 84 ==> Serial 85 ==> Serial 86 ==> Serial 87 ==> Serial 88 ==> Serial 89 ==> Serial 90 ==> Serial 91 ==> Serial 92 ==> Serial 93 ==> Serial 94 ==> Serial 95 ==> Serial 96 ==> Serial 97 ==> Serial 98 ==> Serial 99 ==> Serial 100 ==> COMPFEST16{v3rY_st4nd4Rd_k3ygEn_3794611e09}
```

There's the flag!

Flag: `COMPFEST16{v3rY_st4nd4Rd_k3ygEn_3794611e09}`
