package com.dyzn.genesis.module_process.netty.gen;


@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.13.0)", date = "2020-08-27")
public enum ClientType implements org.apache.thrift.TEnum {
  user(0),
  device(1);

  private final int value;

  private ClientType(int value) {
    this.value = value;
  }

  /**
   * Get the integer value of this enum value, as defined in the Thrift IDL.
   */
  public int getValue() {
    return value;
  }

  /**
   * Find a the enum type by its integer value, as defined in the Thrift IDL.
   * @return null if the value is not found.
   */
  @org.apache.thrift.annotation.Nullable
  public static ClientType findByValue(int value) {
    switch (value) {
      case 0:
        return user;
      case 1:
        return device;
      default:
        return null;
    }
  }
}
