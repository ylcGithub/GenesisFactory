package com.dyzn.genesis.module_process.netty.gen;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.13.0)", date = "2020-08-27")
public class LoginMsg implements org.apache.thrift.TBase<LoginMsg, LoginMsg._Fields>, java.io.Serializable, Cloneable, Comparable<LoginMsg> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("LoginMsg");

  private static final org.apache.thrift.protocol.TField CLIENT_TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField("clientType", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField USER_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("userID", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField PASSWORD_FIELD_DESC = new org.apache.thrift.protocol.TField("password", org.apache.thrift.protocol.TType.STRING, (short)3);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new LoginMsgStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new LoginMsgTupleSchemeFactory();

  /**
   * 
   * @see ClientType
   */
  public @org.apache.thrift.annotation.Nullable
  ClientType clientType; // required
  public @org.apache.thrift.annotation.Nullable String userID; // required
  public @org.apache.thrift.annotation.Nullable String password; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    /**
     * 
     * @see ClientType
     */
    CLIENT_TYPE((short)1, "clientType"),
    USER_ID((short)2, "userID"),
    PASSWORD((short)3, "password");

    private static final java.util.Map<String, _Fields> byName = new java.util.HashMap<String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // CLIENT_TYPE
          return CLIENT_TYPE;
        case 2: // USER_ID
          return USER_ID;
        case 3: // PASSWORD
          return PASSWORD;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.CLIENT_TYPE, new org.apache.thrift.meta_data.FieldMetaData("clientType", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, ClientType.class)));
    tmpMap.put(_Fields.USER_ID, new org.apache.thrift.meta_data.FieldMetaData("userID", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.PASSWORD, new org.apache.thrift.meta_data.FieldMetaData("password", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(LoginMsg.class, metaDataMap);
  }

  public LoginMsg() {
  }

  public LoginMsg(
    ClientType clientType,
    String userID,
    String password)
  {
    this();
    this.clientType = clientType;
    this.userID = userID;
    this.password = password;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public LoginMsg(LoginMsg other) {
    if (other.isSetClientType()) {
      this.clientType = other.clientType;
    }
    if (other.isSetUserID()) {
      this.userID = other.userID;
    }
    if (other.isSetPassword()) {
      this.password = other.password;
    }
  }

  public LoginMsg deepCopy() {
    return new LoginMsg(this);
  }

  @Override
  public void clear() {
    this.clientType = null;
    this.userID = null;
    this.password = null;
  }

  /**
   * 
   * @see ClientType
   */
  @org.apache.thrift.annotation.Nullable
  public ClientType getClientType() {
    return this.clientType;
  }

  /**
   * 
   * @see ClientType
   */
  public LoginMsg setClientType(@org.apache.thrift.annotation.Nullable ClientType clientType) {
    this.clientType = clientType;
    return this;
  }

  public void unsetClientType() {
    this.clientType = null;
  }

  /** Returns true if field clientType is set (has been assigned a value) and false otherwise */
  public boolean isSetClientType() {
    return this.clientType != null;
  }

  public void setClientTypeIsSet(boolean value) {
    if (!value) {
      this.clientType = null;
    }
  }

  @org.apache.thrift.annotation.Nullable
  public String getUserID() {
    return this.userID;
  }

  public LoginMsg setUserID(@org.apache.thrift.annotation.Nullable String userID) {
    this.userID = userID;
    return this;
  }

  public void unsetUserID() {
    this.userID = null;
  }

  /** Returns true if field userID is set (has been assigned a value) and false otherwise */
  public boolean isSetUserID() {
    return this.userID != null;
  }

  public void setUserIDIsSet(boolean value) {
    if (!value) {
      this.userID = null;
    }
  }

  @org.apache.thrift.annotation.Nullable
  public String getPassword() {
    return this.password;
  }

  public LoginMsg setPassword(@org.apache.thrift.annotation.Nullable String password) {
    this.password = password;
    return this;
  }

  public void unsetPassword() {
    this.password = null;
  }

  /** Returns true if field password is set (has been assigned a value) and false otherwise */
  public boolean isSetPassword() {
    return this.password != null;
  }

  public void setPasswordIsSet(boolean value) {
    if (!value) {
      this.password = null;
    }
  }

  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable Object value) {
    switch (field) {
    case CLIENT_TYPE:
      if (value == null) {
        unsetClientType();
      } else {
        setClientType((ClientType)value);
      }
      break;

    case USER_ID:
      if (value == null) {
        unsetUserID();
      } else {
        setUserID((String)value);
      }
      break;

    case PASSWORD:
      if (value == null) {
        unsetPassword();
      } else {
        setPassword((String)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  public Object getFieldValue(_Fields field) {
    switch (field) {
    case CLIENT_TYPE:
      return getClientType();

    case USER_ID:
      return getUserID();

    case PASSWORD:
      return getPassword();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case CLIENT_TYPE:
      return isSetClientType();
    case USER_ID:
      return isSetUserID();
    case PASSWORD:
      return isSetPassword();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof LoginMsg)
      return this.equals((LoginMsg)that);
    return false;
  }

  public boolean equals(LoginMsg that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_clientType = true && this.isSetClientType();
    boolean that_present_clientType = true && that.isSetClientType();
    if (this_present_clientType || that_present_clientType) {
      if (!(this_present_clientType && that_present_clientType))
        return false;
      if (!this.clientType.equals(that.clientType))
        return false;
    }

    boolean this_present_userID = true && this.isSetUserID();
    boolean that_present_userID = true && that.isSetUserID();
    if (this_present_userID || that_present_userID) {
      if (!(this_present_userID && that_present_userID))
        return false;
      if (!this.userID.equals(that.userID))
        return false;
    }

    boolean this_present_password = true && this.isSetPassword();
    boolean that_present_password = true && that.isSetPassword();
    if (this_present_password || that_present_password) {
      if (!(this_present_password && that_present_password))
        return false;
      if (!this.password.equals(that.password))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetClientType()) ? 131071 : 524287);
    if (isSetClientType())
      hashCode = hashCode * 8191 + clientType.getValue();

    hashCode = hashCode * 8191 + ((isSetUserID()) ? 131071 : 524287);
    if (isSetUserID())
      hashCode = hashCode * 8191 + userID.hashCode();

    hashCode = hashCode * 8191 + ((isSetPassword()) ? 131071 : 524287);
    if (isSetPassword())
      hashCode = hashCode * 8191 + password.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(LoginMsg other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetClientType()).compareTo(other.isSetClientType());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetClientType()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.clientType, other.clientType);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetUserID()).compareTo(other.isSetUserID());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetUserID()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.userID, other.userID);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetPassword()).compareTo(other.isSetPassword());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPassword()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.password, other.password);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  @org.apache.thrift.annotation.Nullable
  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    scheme(iprot).read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("LoginMsg(");
    boolean first = true;

    sb.append("clientType:");
    if (this.clientType == null) {
      sb.append("null");
    } else {
      sb.append(this.clientType);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("userID:");
    if (this.userID == null) {
      sb.append("null");
    } else {
      sb.append(this.userID);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("password:");
    if (this.password == null) {
      sb.append("null");
    } else {
      sb.append(this.password);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class LoginMsgStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public LoginMsgStandardScheme getScheme() {
      return new LoginMsgStandardScheme();
    }
  }

  private static class LoginMsgStandardScheme extends org.apache.thrift.scheme.StandardScheme<LoginMsg> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, LoginMsg struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // CLIENT_TYPE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.clientType = ClientType.findByValue(iprot.readI32());
              struct.setClientTypeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // USER_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.userID = iprot.readString();
              struct.setUserIDIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // PASSWORD
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.password = iprot.readString();
              struct.setPasswordIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, LoginMsg struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.clientType != null) {
        oprot.writeFieldBegin(CLIENT_TYPE_FIELD_DESC);
        oprot.writeI32(struct.clientType.getValue());
        oprot.writeFieldEnd();
      }
      if (struct.userID != null) {
        oprot.writeFieldBegin(USER_ID_FIELD_DESC);
        oprot.writeString(struct.userID);
        oprot.writeFieldEnd();
      }
      if (struct.password != null) {
        oprot.writeFieldBegin(PASSWORD_FIELD_DESC);
        oprot.writeString(struct.password);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class LoginMsgTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public LoginMsgTupleScheme getScheme() {
      return new LoginMsgTupleScheme();
    }
  }

  private static class LoginMsgTupleScheme extends org.apache.thrift.scheme.TupleScheme<LoginMsg> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, LoginMsg struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetClientType()) {
        optionals.set(0);
      }
      if (struct.isSetUserID()) {
        optionals.set(1);
      }
      if (struct.isSetPassword()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetClientType()) {
        oprot.writeI32(struct.clientType.getValue());
      }
      if (struct.isSetUserID()) {
        oprot.writeString(struct.userID);
      }
      if (struct.isSetPassword()) {
        oprot.writeString(struct.password);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, LoginMsg struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        struct.clientType = ClientType.findByValue(iprot.readI32());
        struct.setClientTypeIsSet(true);
      }
      if (incoming.get(1)) {
        struct.userID = iprot.readString();
        struct.setUserIDIsSet(true);
      }
      if (incoming.get(2)) {
        struct.password = iprot.readString();
        struct.setPasswordIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}
