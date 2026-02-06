Perusahaan PT. Contoso mengalami kebocoran data internal.
Sebuah file Excel berisi laporan keuangan tersebar ke publik.

Namun, kabar beredar bahwa file ini menyimpan sesuatu yang lebih dari sekadar angka.
Bisakah kamu menemukan rahasia di balik spreadsheet ini?

    Note: Flag terbagi menjadi dua bagian

## Solution

```
 $ binwalk Internal_Audit_2025.xlsx

                                                                                      /Users/vinnie/CTF/Forensics/FGTE/Excel Leak/Internal_Audit_2025.xlsx
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
DECIMAL                            HEXADECIMAL                        DESCRIPTION
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
0                                  0x0                                ZIP archive, file count: 14, total size: 23079 bytes
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

Analyzed 1 file for 85 file signatures (196 magic patterns) in 13.0 milliseconds

  $ binwalk -e Internal_Audit_2025.xlsx

                                                                                /Users/vinnie/CTF/Forensics/FGTE/Excel Leak/extractions/Internal_Audit_2025.xlsx
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
DECIMAL                            HEXADECIMAL                        DESCRIPTION
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
0                                  0x0                                ZIP archive, file count: 14, total size: 23079 bytes
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
[+] Extraction of zip data at offset 0x0 completed successfully
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

Analyzed 1 file for 85 file signatures (196 magic patterns) in 173.0 milliseconds

  $ ls
extractions              Internal_Audit_2025.xlsx README.md

  $ cd extractions

 $  ...FGTE/Excel Leak/extractions     ls                                                                                                                                                                                         22:19:52 
Internal_Audit_2025.xlsx           Internal_Audit_2025.xlsx.extracted

 $  ...FGTE/Excel Leak/extractions     rg FGTE                                                                                                                                                                                    22:19:53 
Internal_Audit_2025.xlsx.extracted/0/xl/worksheets/sheet5.xml
1:<worksheet xmlns="http://schemas.openxmlformats.org/spreadsheetml/2006/main"><sheetPr><outlinePr summaryBelow="1" summaryRight="1"/><pageSetUpPr/></sheetPr><dimension ref="A1:ZZ1000"/><sheetViews><sheetView workbookViewId="0"><selection activeCell="A1" sqref="A1"/></sheetView></sheetViews><sheetFormatPr baseColWidth="8" defaultRowHeight="15"/><sheetData><row r="1"><c r="A1" t="inlineStr"><is><t>Audit trail (internal)</t></is></c></row><row r="2"><c r="A2" t="inlineStr"><is><t>AL0001</t></is></c><c r="B2" t="inlineStr"><is><t>2023-06-04T00:00:00</t></is></c><c r="C2" t="inlineStr"><is><t>E0064</t></is></c><c r="D2" t="inlineStr"><is><t>backup</t></is></c></row><row r="3"><c r="A3" t="inlineStr"><is><t>AL0002</t></is></c><c r="B3" t="inlineStr"><is><t>2024-09-27T00:00:00</t></is></c><c r="C3" t="inlineStr"><is><t>E0061</t></is></c><c r="D3" t="inlineStr"><is><t>login</t></is></c></row><row r="4"><c r="A4" t="inlineStr"><is><t>AL0003</t></is></c><c r="B4" t="inlineStr"><is><t>2024-02-19T00:00:00</t></is></c><c r="C4" t="inlineStr"><is><t>E0069</t></is></c><c r="D4" t="inlineStr"><is><t>backup</t></is></c></row><row r="5"><c r="A5" t="inlineStr"><is><t>AL0004</t></is></c><c r="B5" t="inlineStr"><is><t>2023-08-08T00:00:00</t></is></c><c r="C5" t="inlineStr"><is><t>E0068</t></is></c><c r="D5" t="inlineStr"><is><t>login</t></is></c></row><row r="6"><c r="A6" t="inlineStr"><is><t>AL0005</t></is></c><c r="B6" t="inlineStr"><is><t>2024-04-20T00:00:00</t></is></c><c r="C6" t="inlineStr"><is><t>E0002</t></is></c><c r="D6" t="inlineStr"><is><t>login</t></is></c></row><row r="7"><c r="A7" t="inlineStr"><is><t>AL0006</t></is></c><c r="B7" t="inlineStr"><is><t>2024-09-14T00:00:00</t></is></c><c r="C7" t="inlineStr"><is><t>E0008</t></is></c><c r="D7" t="inlineStr"><is><t>config change</t></is></c></row><row r="8"><c r="A8" t="inlineStr"><is><t>AL0007</t></is></c><c r="B8" t="inlineStr"><is><t>2024-03-24T00:00:00</t></is></c><c r="C8" t="inlineStr"><is><t>E0063</t></is></c><c r="D8" t="inlineStr"><is><t>export</t></is></c></row><row r="9"><c r="A9" t="inlineStr"><is><t>AL0008</t></is></c><c r="B9" t="inlineStr"><is><t>2023-03-03T00:00:00</t></is></c><c r="C9" t="inlineStr"><is><t>E0069</t></is></c><c r="D9" t="inlineStr"><is><t>login</t></is></c></row><row r="10"><c r="A10" t="inlineStr"><is><t>AL0009</t></is></c><c r="B10" t="inlineStr"><is><t>2024-02-07T00:00:00</t></is></c><c r="C10" t="inlineStr"><is><t>E0051</t></is></c><c r="D10" t="inlineStr"><is><t>login</t></is></c></row><row r="11"><c r="A11" t="inlineStr"><is><t>AL0010</t></is></c><c r="B11" t="inlineStr"><is><t>2024-06-23T00:00:00</t></is></c><c r="C11" t="inlineStr"><is><t>E0028</t></is></c><c r="D11" t="inlineStr"><is><t>backup</t></is></c></row><row r="1000"><c r="ZZ1000" t="inlineStr"><is><t>FGTE{So_Many_Tabs_</t></is></c></row></sheetData><pageMargins left="0.75" right="0.75" top="1" bottom="1" header="0.5" footer="0.5"/></worksheet>
```

That's the first part! `FGTE{So_Many_Tabs_`.
I looked at all of the files, and for the last one, I got to `xl/worksheets/sheet6.xml`.
In that file is a weirdly encoded `CHAR`s, and my gut said "this is it!"

```xml
<worksheet xmlns="http://schemas.openxmlformats.org/spreadsheetml/2006/main"><sheetPr><outlinePr summaryBelow="1" summaryRight="1"/><pageSetUpPr/></sheetPr><dimension ref="C10:C12"/><sheetViews><sheetView workbookViewId="0"><selection activeCell="A1" sqref="A1"/></sheetView></sheetViews><sheetFormatPr baseColWidth="8" defaultRowHeight="15"/><sheetData><row r="10"><c r="C10"><f>CHAR(83)&amp;CHAR(111)&amp;CHAR(95)&amp;CHAR(76)&amp;CHAR(105)&amp;CHAR(116)&amp;CHAR(116)&amp;CHAR(108)&amp;CHAR(101)&amp;CHAR(95)</f><v></v></c></row><row r="11"><c r="C11"><f>CHAR(84)&amp;CHAR(105)&amp;CHAR(109)&amp;CHAR(101)&amp;CHAR(95)&amp;CHAR(50)&amp;CHAR(48)&amp;CHAR(50)&amp;CHAR(53)&amp;CHAR(125)</f><v></v></c></row><row r="12"><c r="C12"><f>C10 &amp; C11</f><v></v></c></row></sheetData><pageMargins left="0.75" right="0.75" top="1" bottom="1" header="0.5" footer="0.5"/></worksheet>
```

```python
>>> ''.join([chr(x) for x in [83, 111, 95, 76, 105, 116, 116, 108, 101, 95, 84, 105, 109, 101, 95, 50, 48, 50, 53, 125]])
'So_Little_Time_2025}'
```
