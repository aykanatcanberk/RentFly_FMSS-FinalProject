Feature: Login Functionality

  Scenario: Login sayfasının başarılı bir şekilde açılması
    Given kullanıcı uygulamayı açmış olmalı
    Then kullanıcı login sayfasını görmelidir

  Scenario: Email ile geçerli bilgilerle giriş yapma
    Given kullanıcı uygulamayı açmış olmalı
    When email alanına "test@example.com" girilir
    And şifre alanına "correctPassword" girilir
    And Giriş Yap butonuna tıklanır
    Then kullanıcı başarılı bir şekilde giriş yapar ve ana sayfaya yönlendirilir

  Scenario: Email ile hatalı bilgilerle giriş yapma
    Given kullanıcı uygulamayı açmış olmalı
    When email alanına "yanlistest@example.com" girilir
    And şifre alanına "correctPassword" girilir
    And Giriş Yap butonuna tıklanır
    Then kullanıcı "Girilen bilgiler geçersiz." hata mesajını alır ve giriş yapamaz

  Scenario: Email ile hatalı bilgilerle giriş yapma (Şifre hatalı)
    Given kullanıcı uygulamayı açmış olmalı
    When email alanına "test@example.com" girilir
    And şifre alanına "wrongPassword" girilir
    And Giriş Yap butonuna tıklanır
    Then kullanıcı "Girilen bilgiler geçersiz." hata mesajını alır ve giriş yapamaz

  Scenario: Telefon numarası ile geçerli bilgilerle giriş yapma
    Given kullanıcı uygulamayı açmış olmalı
    When telefon numarası alanına "5551234567" girilir
    And şifre alanına "correctPassword" girilir
    And Giriş Yap butonuna tıklanır
    Then kullanıcı başarılı bir şekilde giriş yapar ve ana sayfaya yönlendirilir

  Scenario: Telefon numarası ile hatalı bilgilerle giriş yapma (Numara hatalı)
    Given kullanıcı uygulamayı açmış olmalı
    When telefon numarası alanına "0000000000" girilir
    And şifre alanına "correctPassword" girilir
    And Giriş Yap butonuna tıklanır
    Then kullanıcı "Girilen bilgiler geçersiz." hata mesajını alır ve giriş yapamaz

  Scenario: Telefon numarası ile hatalı bilgilerle giriş yapma (Şifre hatalı)
    Given kullanıcı uygulamayı açmış olmalı
    When telefon numarası alanına "5551234567" girilir
    And şifre alanına "wrongPassword" girilir
    And Giriş Yap butonuna tıklanır
    Then kullanıcı "Girilen bilgiler geçersiz." hata mesajını alır ve giriş yapamaz

  Scenario: Boş email veya telefon numarası ile giriş yapmaya çalışma
    Given kullanıcı uygulamayı açmış olmalı
    When email alanına "" girilir
    And şifre alanına "correctPassword" girilir
    And Giriş Yap butonuna tıklanır
    Then kullanıcı "Email veya telefon numarası gerekli" hata mesajı alır ve giriş yapamaz

  Scenario: Şifre girmeden giriş yapmaya çalışma
    Given kullanıcı uygulamayı açmış olmalı
    When email alanına "test@example.com" girilir
    And şifre alanına "" girilir
    And Giriş Yap butonuna tıklanır
    Then kullanıcı "Şifre kullanmadan giriş yapılamaz." hata mesajı alır ve giriş yapamaz

  Scenario: Google hesabı ile giriş yapma
    Given kullanıcı uygulamayı açmış olmalı
    When Google ile Giriş Yap butonuna tıklanır
    Then kullanıcı Google hesap seçim ekranını görmelidir
    When Google hesabını seç
    Then kullanıcı başarılı bir şekilde Google hesabıyla giriş yapar ve ana sayfaya yönlendirilir

  Scenario: Facebook hesabı ile giriş yapma
    Given kullanıcı uygulamayı açmış olmalı
    When Facebook ile Giriş Yap butonuna tıklanır
    Then kullanıcı Facebook giriş ekranını görmelidir
    When Facebook hesabını seç
    Then kullanıcı başarılı bir şekilde Facebook hesabıyla giriş yapar ve ana sayfaya yönlendirilir
