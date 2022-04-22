Feature: Menu Cek Penilaian - Upliner

  @TestingMenu
  Scenario: Menu Cek Penilaian
 
    When SPV klik menu Cek Penilaian
    Then Menampilkan Data Cek Penilaian
    #Scenario: Testing Edit Action
    When SPV klik button Action
    And SPV klik Quantity Aspect
    Then SPV Update Penilaian Quantity Aspect
    And SPV Cancel Penilaian Quantity Aspect
   	#Scenario: Testing Quality Aspect
   	When SPV klik Quality Aspect
    Then SPV Update Penilaian Quality Aspect
    And SPV Cancel Penilaian Quality Aspect
    #Scenario: Testing Aspiration
    When SPV klik Aspiration
    Then SPV Update Penilaian Aspiration
    And SPV Cancel Penilaian Aspiration
		#Scenario: Testing Final Rating
    When SPV klik Final Rating
    Then SPV Simpan Data Penilaian
    And Menampilkan notifikasi Berhasil! dan Data tersimpan
    #Scenario: Testing Page
    When SPV klik Next Page and Previous Page
    #Scenario: Testing Show Range Data CekPenilaian
		And SPV klik Show Entries
		Then Menampilkan data Cek Penilaian sesuai banyaknya data yang dipilih
		#Scenario: Testing Sorting Data CekPenilaian
		When SPV klik sorting pada Tabel Detail
		Then Menampilkan data Cek Penilaian secara ascending	
		#Scenario: Testing Search Data CekPenilaian
		When SPV search data
		Then Menampilkan data yang dicari