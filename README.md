DETYRE KURSI
Programim i Orientuar nga Objekti 2023-2024
Loja e labirintit

1. Koncepti i lojes:
   - Lojtari do te levize ne nje labirint te gjeneruar dinamikisht me qellimin e arritjes se daljes.
   - Ne loje jane te vendosura dhe thesare qe i mbledh lojtari gate kohes qe leviz.
   - Lojtari fiton duke arritur daljen me maksimumin e pikeve dhe loja mund te ruhet dhe te ringarkohet.
2. Projektimi I klasave dhe implementimi:
2.1 Klasa Lojtar:
   - Atributet:
     - Pozicioni i lojtarit ne loje.
     - Numri i thesareve te mbledhura.
     - Piket e fituara.
   - Metodat:
     - leviz: Lejon lojtarin te levize ne labirint.
     - mblidhThesar: Mbledh thesaret.
     - eshteNeDalje: Kontrollon nese lojtari ka arritur daljen.
2.2 Klasa Labirint:
   - Atributet:
     - Nje rrjet dinamik qe paraqet labirintin.
     - Vendndodhja e thesareve dhe daljes.
   - Metodat:
     - gjeneroLabirint: Krijon nje labirint ne menyre dinamike me mure, rruge te hapura, thesare dhe dalje.
     - eshteMur: Kontrollon nese nje vendndodhje specifike ne labirint eshte nje mur.
     - eshteThesar: Kontrollon nese nje vendndodhje specifike ne labirint permban nje thesar.
     - eshteDalje: Kontrollon nese nje vendndodhje specifike ne labirint eshte dalja.
2.3 Klasa KontrolleriLojes:
   - Atributet:
     - Objektet Lojtar dhe Labirint.
     - Statusi i lojes (ne vazhdim, fituar, humbur).
   - Metodat:
     - filloLoje: Inicializon nje loje te re me nje labirint te ri te gjeneruar dinamikisht.
     - luajRadhen: Menaxhon cdo radhe, duke lejuar lojtarin te levize dhe te mbledhe thesare.
     - perfundoLojen: Percakton rezultatin e lojes, update-on piket dhe shfaq rezultatet.
     - ruajLojen: Ruan gjendjen aktuale te lojes, duke perfshire piket e lojareve dhe formen e labirintit ne nje file.
     - ngarkoLojen: Ngarkon gjendjen e nje loje te meparshme.
3. Menuja e bazuar ne console (Jo-GUI):
   - Opsionet e menuse:
      1. Fillo nje loje te re.
      2. Leviz ne nje drejtim specifik (lart, poshte, majtas, djathtas).
      3. Shfaq pozicionin actual te lojtarit, piket dhe thesaret.
      4. Ruaj progresin e lojes.
      5. Ngarko nje loje te ruajtur.
      6. Dil.
4. Nderfaqja grafike me perdoruesin (GUI) duke perdorur Java Swing (Opsionale):
    - Komponentet GUI:
      1. Shfaq labirintin e gjeneruar dinamikisht me mure, rruge te hapura dhe daljen.
      2. Butona per levizje (poshte, lart, majtas, djathtas).
      3. Paneli i informacionit qe shfaq pozicionin actual te lojtarit, piket dhe thesaret.
      4. Butona per ruajtjen dhe ngarkimin.
      5. Buton per daljen.
   - Funksionaliteti:
     - Buttons trigger corresponding actions, updating the GUI components.
     - Validim iI inputit nga perdoruesi.
     - Paraqitje vizuale e labirintit dhe levizjeve te perdoruesit.
5. Mekanika e lojes:
   - Mbledhja e thesarit:
     - Ndersa lojtari leviz ne labirint, mund te mbledhin thesare ne baze te te cilave llogariten pike.
   - Arritja e qellimit:
     - Lojtari fiton kur arrin daljen me numrin maksimal te thesareve.
     - Lojtari humb nese perplasen me nje mu rose nese dalja arrihet me pak thesare.
6. Menaxhimi i File-ve:
   - Ruaj lojen:
     - Lejo lojtarin te ruaje gjendjen aktuale te lojes, duke perfshire piken e lojtarit dhe formen e labirintit ne nje file.
   - Ngarkimi i lojes:
     - Lejo ngarkimin e gjendjes se nje loje te ruajtur me pare, duke rikthyer progresin e lojtarit dhe formen e labirintit.
