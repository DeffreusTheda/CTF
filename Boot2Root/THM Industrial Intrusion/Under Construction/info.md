```
Open 10.10.41.156:22
Open 10.10.41.156:80
[~] Starting Script(s)
[~] Starting Nmap 7.95 ( https://nmap.org ) at 2025-06-28 21:14 WIB
Initiating Ping Scan at 21:14
Scanning 10.10.41.156 [2 ports]
Completed Ping Scan at 21:14, 0.23s elapsed (1 total hosts)
Initiating Parallel DNS resolution of 1 host. at 21:14
Completed Parallel DNS resolution of 1 host. at 21:14, 0.05s elapsed
DNS resolution of 1 IPs took 0.07s. Mode: Async [#: 2, OK: 0, NX: 1, DR: 0, SF: 0, TR: 1, CN: 0]
Initiating Connect Scan at 21:14
Scanning 10.10.41.156 [2 ports]
Discovered open port 22/tcp on 10.10.41.156
Discovered open port 80/tcp on 10.10.41.156
Completed Connect Scan at 21:14, 0.23s elapsed (2 total ports)
Nmap scan report for 10.10.41.156
Host is up, received syn-ack (0.23s latency).
Scanned at 2025-06-28 21:14:08 WIB for 0s

PORT   STATE SERVICE REASON
22/tcp open  ssh     syn-ack
80/tcp open  http    syn-ack

Read data files from: /opt/homebrew/bin/../share/nmap
Nmap done: 1 IP address (1 host up) scanned in 0.55 seconds
```

```
Starting Nmap 7.95 ( https://nmap.org ) at 2025-06-28 21:21 WIB
Nmap scan report for 10.10.41.156
Host is up (0.38s latency).

PORT   STATE SERVICE VERSION
80/tcp open  http    Apache httpd 2.4.58 ((Ubuntu))
|_http-title: Industrial Dev Solutions
|_http-server-header: Apache/2.4.58 (Ubuntu)

Service detection performed. Please report any incorrect results at https://nmap.org/submit/ .
Nmap done: 1 IP address (1 host up) scanned in 14.50 seconds
```
