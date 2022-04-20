Feature: SPV Login to HRIS - PA Employee Upliner

  @LoginInvalid
  Scenario: Testing Login Upliner Invalid
  	Given SPV mengakses url
    When SPV invalid login
    Then SPV gagal login
      
  @LoginValid
  Scenario: Testing Login Upliner Valid
    When SPV valid login
    Then SPV berhasil login
    