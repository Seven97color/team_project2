package model.entity;

import java.io.Serializable;

public class UserBean implements Serializable {
  /**
   * customer_managerID
   */
  private String userId;

  /**
   * customer_managerパスワード
   */
  private String password;

  /**
   * デフォルトコンストラクタ
   */
  public UserBean() {

  }

  /**
   * @return userId
   */
  public String getUserId() {
    return userId;
  }

  /**
   * @param userId セットする userId
   */
  public void setUserId(String userId) {
    this.userId = userId;
  }

  /**
   * @return password
   */
  public String getPassword() {
    return password;
   }

  /**
   * @param password セットする password
   */
  public void setPassword(String password) {
    this.password = password;
  }
}