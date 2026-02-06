## Description

###### Author: xnull

Holy guacamoly. I somehow managed to download a evil potato and all my super secret browser history got leaked. I hope no one finds the password to my OnlySHC Account :(

## Solution

```
$ strings evil_potato.pcapng | rg 'shc2023'
GET /search?q=shc2023%7Bdel3te_the_brows3r_hist0ry_before_i_di3%7D HTTP/1.1
Location: https://www.google.com/search?q=shc2023%7Bdel3te_the_brows3r_hist0ry_before_i_di3%7D&gws_rd=ssl
<A HREF="https://www.google.com/search?q=shc2023%7Bdel3te_the_brows3r_hist0ry_before_i_di3%7D&amp;gws_rd=ssl">here</A>.
```

Flag: shc2023{del3te_the_brows3r_hist0ry_before_i_di3}
