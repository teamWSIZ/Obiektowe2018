### Java keytool/keystore : certyfikaty do zabezpieczania aplikacji przez SSL/TLS/https

* klucze/certyfikaty można samemu generować (ale trzeba dodawać wyjątki w browserach -- to nie problem dla aplikacji wewnętrznych);
keytool jest dostarczany z dystrybucją javy
`keytool -genkeypair -alias wsiztest -storetype PKCS12 -keyalg RSA -keysize 2048 -keystore keystore.p12 -validity 3650`

* uwaga: pod windows `keytool` jest w folderze `bin` dystrybucji javy; 
trzeba go sobie dodać do `PATH`

* notka: https://stackoverflow.com/questions/49324700/enable-https-with-self-signed-certificate-in-spring-boot-2-0

* można sprawdzić zawartość keystore-a przez:

    `keytool -list -v -keystore keystore.p12`

    prawidlowy output:
 ```
    Enter keystore password:
    Keystore type: jks
    Keystore provider: SUN
    
    Your keystore contains 1 entry
    
    Alias name: wsiztest
    Creation date: Nov 23, 2018
    Entry type: PrivateKeyEntry
    Certificate chain length: 1
    Certificate[1]:
    Owner: CN=Unknown, OU=Unknown, O=Unknown, L=Unknown, ST=Unknown, C=Unknown
    Issuer: CN=Unknown, OU=Unknown, O=Unknown, L=Unknown, ST=Unknown, C=Unknown
    Serial number: 11394ebd
    Valid from: Fri Nov 23 23:18:08 CET 2018 until: Mon Nov 20 23:18:08 CET 2028
    Certificate fingerprints:
             MD5:  D5:6E:11:E9:26:2D:98:B7:FF:7B:EC:8B:75:60:A4:B5
             SHA1: 0E:23:DF:28:5E:86:8B:F2:B5:D4:33:BD:03:78:30:54:FC:AE:FE:E4
             SHA256: 37:E3:14:5B:9C:33:31:E5:86:1D:47:73:71:D3:10:DF:77:80:AC:42:C1:A2:F2:CE:3B:AB:5D:35:81:EB:A9:34
    Signature algorithm name: SHA256withRSA
    Subject Public Key Algorithm: 2048-bit RSA key
    Version: 3
    
    Extensions:
    
    #1: ObjectId: 2.5.29.14 Criticality=false
    SubjectKeyIdentifier [
    KeyIdentifier [
    0000: D9 FE 5F 05 CF B2 3F A4   4E F9 B6 35 A6 7A 36 E2  .._...?.N..5.z6.
    0010: 32 C5 98 BC                                        2...
    ]
    ]
```

