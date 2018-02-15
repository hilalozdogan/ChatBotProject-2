# ChatBotProjesi-2

### Gereksinimler:
Proje kapsamında, kullanıcı yorumlarına göre en beğenilen ürünlerin belirlenmesine yönelik olarak bir alışveriş sohbet robotu uygulaması tasarım desenlerine uygun şekilde geliştirilecektir. Öncelikle örneği yapılan sohbet robotu  uygulamasının rastlantısallık katılmış “selamlama” ve “istisna” aşamalarına ek olarak “hal, hatır sorma” ve “vedalaşma” durumları da eklenecektir.
Örnek senaryo aşağıda listelenmiştir;
 #### 1.	Selamlama
- a.	Siz: selamlar
- b.	Bot: merhaba
- c.	Siz: hosgeldin (istisna durumu)
- d.	Bot: anlasilmadi ??? lutfen tekrarlar misiniz?

 #### 2.	Hal, Hatır Sorma
- a.	Siz: nasilsiniz?
- b.	Bot: Tesekkurler, iyiyim. siz?
- (Ürün seçme ve kullanıcı yorumlarına göre en beğenilen ürünlerin belirlenme diyaloğu)

 #### 3.	Vedalaşma
- a.	Siz: gule gule
- b.	Bot: hoscakalin...

Ürün seçme ve kullanıcı yorumlarına göre en beğenilen ürünlerin belirlenme aşamasında ise yapılacaklar şu şekilde listelenmiştir;

**1.**	Ürün seçimi yapılmadan önce ürün bilgisi kullanıcı arayüzünden sisteme girilmesi gerekmektedir. Ürün hiyerarşisi oluşturulurken **Fabrika deseni** kullanılmalıdır. Ürün kategorisi (Elektronik, Beyaz Eşya, vb.), marka ve model bilgisi ile birlikte ürünün türüne göre detay bilgileri (cep telefonu için ekran boyutu, kamera çözünürlüğü, fiyatı vb.) kaydedilecektir. Girilen ürünlere ait 10 adet Twitter yorumu da elle seçilerek kullanıcı yorumları arayüzünden girilebileceği gibi Twitter4J  kütüphanesi kullanılarak arayüz olmadan da toplanabilinir. Bu aşamada uygun sınıf hiyerarşisinin sağlanması beklenecektir.

**2.**	Twitter yorumlarından en beğenilen ürünlerin belirlenme aşamasında ise SenticNet 4  kaynağı **Singleton deseni** ile kullanılacaktır. Bu kaynakta yer alan dosyada İngilizce terimin kutup değerine göre olumlu yada olumsuz anlam taşıdığının bilgisi tutulmaktadır.
- Örneğin,
- good	positive	0.664
- bad	negative	-0.36
- Sıfırın üzerinde yer alan “good” terimi olumlu anlama gelirken “bad” kelimesi negatif değer taşıdığı için olumsuz anlam içermektedir.

Kullanıcı yorumları için Türkçe metin toplandığı takdirde SenticNet kaynağındaki terimlerin Google Translate API  yada başka bir kütüphane ile kod yazılarak Türkçe karşılıklarının bulunması gerekmektedir. İngilizce yada Türkçe dilinde bir ürüne ait yorumların her biri daha sonra kelimelerine ayrıştırılarak tek tek SenticNet kaynağında sorgulanarak kutup değerleri alınacaktır. Tek bir ürün için yorumlarda yer alan varsa terimlerin kutup değerlerinin ortalaması alınarak o ürün için genel kullanıcı sezgisi belirlenecektir.  Sezgi değerleri hesaplanırken ortalama alınmasına ek olarak başka bir hesaplama yönteminin de eklenerek **Strateji deseni** kullanılacaktır. Eklenen bu hesaplama yönteminin özgünlüğünden çok **Strateji deseni** sayesinde hesaplamaların esnekliğini sağlanması beklenmektedir. Bu aşamada, Tweet sınıfında hashtag, yorum ve kutup değeri tutulacaktır. Her bir ürün için elde edilen sezgi değerleri Tweet sınıfı üzerinden Comparable arayüzü ile sıralanarak en çok beğenilen ürün (cep telefonu, televizyon, giysi, vb.) sohbet robotu tarafından diyalog sırasında sunulacaktır.

Son olarak projede birim test (JUnit , vd.) kullanılarak uygulama içindeki belirli durumların test edilmesi beklenmektedir. Örneğin, sezgi hesabının doğru yapılıp yapılmadığı ya da SenticNet kaynağından çekilen verinin kontrolü gibi testler yapılabilir.
