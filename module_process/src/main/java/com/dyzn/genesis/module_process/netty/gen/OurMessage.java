package com.dyzn.genesis.module_process.netty.gen;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.13.0)", date = "2020-08-27")
public class OurMessage implements org.apache.thrift.TBase<OurMessage, OurMessage._Fields>, java.io.Serializable, Cloneable, Comparable<OurMessage> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("OurMessage");

  private static final org.apache.thrift.protocol.TField MSG_FLAG_FIELD_DESC = new org.apache.thrift.protocol.TField("msg_flag", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField DATA_TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField("data_type", org.apache.thrift.protocol.TType.I32, (short)2);
  private static final org.apache.thrift.protocol.TField DATA_BODY_FIELD_DESC = new org.apache.thrift.protocol.TField("data_body", org.apache.thrift.protocol.TType.STRUCT, (short)3);
  private static final org.apache.thrift.protocol.TField RESULT_MSG_FIELD_DESC = new org.apache.thrift.protocol.TField("result_msg", org.apache.thrift.protocol.TType.STRUCT, (short)4);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new OurMessageStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new OurMessageTupleSchemeFactory();

  /**
   * 
   * @see MsgFlag
   */
  public @org.apache.thrift.annotation.Nullable
  MsgFlag msg_flag; // required
  /**
   * 
   * @see DataType
   */
  public @org.apache.thrift.annotation.Nullable
  DataType data_type; // optional
  public @org.apache.thrift.annotation.Nullable DataBody data_body; // optional
  public @org.apache.thrift.annotation.Nullable
  ResultMsg result_msg; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    /**
     * 
     * @see MsgFlag
     */
    MSG_FLAG((short)1, "msg_flag"),
    /**
     * 
     * @see DataType
     */
    DATA_TYPE((short)2, "data_type"),
    DATA_BODY((short)3, "data_body"),
    RESULT_MSG((short)4, "result_msg");

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
        case 1: // MSG_FLAG
          return MSG_FLAG;
        case 2: // DATA_TYPE
          return DATA_TYPE;
        case 3: // DATA_BODY
          return DATA_BODY;
        case 4: // RESULT_MSG
          return RESULT_MSG;
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
  private static final _Fields optionals[] = {_Fields.DATA_TYPE, _Fields.DATA_BODY, _Fields.RESULT_MSG};
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.MSG_FLAG, new org.apache.thrift.meta_data.FieldMetaData("msg_flag", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, MsgFlag.class)));
    tmpMap.put(_Fields.DATA_TYPE, new org.apache.thrift.meta_data.FieldMetaData("data_type", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, DataType.class)));
    tmpMap.put(_Fields.DATA_BODY, new org.apache.thrift.meta_data.FieldMetaData("data_body", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, DataBody.class)));
    tmpMap.put(_Fields.RESULT_MSG, new org.apache.thrift.meta_data.FieldMetaData("result_msg", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, ResultMsg.class)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(OurMessage.class, metaDataMap);
  }

  public OurMessage() {
  }

  public OurMessage(
    MsgFlag msg_flag)
  {
    this();
    this.msg_flag = msg_flag;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public OurMessage(OurMessage other) {
    if (other.isSetMsg_flag()) {
      this.msg_flag = other.msg_flag;
    }
    if (other.isSetData_type()) {
      this.data_type = other.data_type;
    }
    if (other.isSetData_body()) {
      this.data_body = new DataBody(other.data_body);
    }
    if (other.isSetResult_msg()) {
      this.result_msg = new ResultMsg(other.result_msg);
    }
  }

  public OurMessage deepCopy() {
    return new OurMessage(this);
  }

  @Override
  public void clear() {
    this.msg_flag = null;
    this.data_type = null;
    this.data_body = null;
    this.result_msg = null;
  }

  /**
   * 
   * @see MsgFlag
   */
  @org.apache.thrift.annotation.Nullable
  public MsgFlag getMsg_flag() {
    return this.msg_flag;
  }

  /**
   * 
   * @see MsgFlag
   */
  public OurMessage setMsg_flag(@org.apache.thrift.annotation.Nullable MsgFlag msg_flag) {
    this.msg_flag = msg_flag;
    return this;
  }

  public void unsetMsg_flag() {
    this.msg_flag = null;
  }

  /** Returns true if field msg_flag is set (has been assigned a value) and false otherwise */
  public boolean isSetMsg_flag() {
    return this.msg_flag != null;
  }

  public void setMsg_flagIsSet(boolean value) {
    if (!value) {
      this.msg_flag = null;
    }
  }

  /**
   * 
   * @see DataType
   */
  @org.apache.thrift.annotation.Nullable
  public DataType getData_type() {
    return this.data_type;
  }

  /**
   * 
   * @see DataType
   */
  public OurMessage setData_type(@org.apache.thrift.annotation.Nullable DataType data_type) {
    this.data_type = data_type;
    return this;
  }

  public void unsetData_type() {
    this.data_type = null;
  }

  /** Returns true if field data_type is set (has been assigned a value) and false otherwise */
  public boolean isSetData_type() {
    return this.data_type != null;
  }

  public void setData_typeIsSet(boolean value) {
    if (!value) {
      this.data_type = null;
    }
  }

  @org.apache.thrift.annotation.Nullable
  public DataBody getData_body() {
    return this.data_body;
  }

  public OurMessage setData_body(@org.apache.thrift.annotation.Nullable DataBody data_body) {
    this.data_body = data_body;
    return this;
  }

  public void unsetData_body() {
    this.data_body = null;
  }

  /** Returns true if field data_body is set (has been assigned a value) and false otherwise */
  public boolean isSetData_body() {
    return this.data_body != null;
  }

  public void setData_bodyIsSet(boolean value) {
    if (!value) {
      this.data_body = null;
    }
  }

  @org.apache.thrift.annotation.Nullable
  public ResultMsg getResult_msg() {
    return this.result_msg;
  }

  public OurMessage setResult_msg(@org.apache.thrift.annotation.Nullable ResultMsg result_msg) {
    this.result_msg = result_msg;
    return this;
  }

  public void unsetResult_msg() {
    this.result_msg = null;
  }

  /** Returns true if field result_msg is set (has been assigned a value) and false otherwise */
  public boolean isSetResult_msg() {
    return this.result_msg != null;
  }

  public void setResult_msgIsSet(boolean value) {
    if (!value) {
      this.result_msg = null;
    }
  }

  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable Object value) {
    switch (field) {
    case MSG_FLAG:
      if (value == null) {
        unsetMsg_flag();
      } else {
        setMsg_flag((MsgFlag)value);
      }
      break;

    case DATA_TYPE:
      if (value == null) {
        unsetData_type();
      } else {
        setData_type((DataType)value);
      }
      break;

    case DATA_BODY:
      if (value == null) {
        unsetData_body();
      } else {
        setData_body((DataBody)value);
      }
      break;

    case RESULT_MSG:
      if (value == null) {
        unsetResult_msg();
      } else {
        setResult_msg((ResultMsg)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  public Object getFieldValue(_Fields field) {
    switch (field) {
    case MSG_FLAG:
      return getMsg_flag();

    case DATA_TYPE:
      return getData_type();

    case DATA_BODY:
      return getData_body();

    case RESULT_MSG:
      return getResult_msg();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case MSG_FLAG:
      return isSetMsg_flag();
    case DATA_TYPE:
      return isSetData_type();
    case DATA_BODY:
      return isSetData_body();
    case RESULT_MSG:
      return isSetResult_msg();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof OurMessage)
      return this.equals((OurMessage)that);
    return false;
  }

  public boolean equals(OurMessage that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_msg_flag = true && this.isSetMsg_flag();
    boolean that_present_msg_flag = true && that.isSetMsg_flag();
    if (this_present_msg_flag || that_present_msg_flag) {
      if (!(this_present_msg_flag && that_present_msg_flag))
        return false;
      if (!this.msg_flag.equals(that.msg_flag))
        return false;
    }

    boolean this_present_data_type = true && this.isSetData_type();
    boolean that_present_data_type = true && that.isSetData_type();
    if (this_present_data_type || that_present_data_type) {
      if (!(this_present_data_type && that_present_data_type))
        return false;
      if (!this.data_type.equals(that.data_type))
        return false;
    }

    boolean this_present_data_body = true && this.isSetData_body();
    boolean that_present_data_body = true && that.isSetData_body();
    if (this_present_data_body || that_present_data_body) {
      if (!(this_present_data_body && that_present_data_body))
        return false;
      if (!this.data_body.equals(that.data_body))
        return false;
    }

    boolean this_present_result_msg = true && this.isSetResult_msg();
    boolean that_present_result_msg = true && that.isSetResult_msg();
    if (this_present_result_msg || that_present_result_msg) {
      if (!(this_present_result_msg && that_present_result_msg))
        return false;
      if (!this.result_msg.equals(that.result_msg))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetMsg_flag()) ? 131071 : 524287);
    if (isSetMsg_flag())
      hashCode = hashCode * 8191 + msg_flag.getValue();

    hashCode = hashCode * 8191 + ((isSetData_type()) ? 131071 : 524287);
    if (isSetData_type())
      hashCode = hashCode * 8191 + data_type.getValue();

    hashCode = hashCode * 8191 + ((isSetData_body()) ? 131071 : 524287);
    if (isSetData_body())
      hashCode = hashCode * 8191 + data_body.hashCode();

    hashCode = hashCode * 8191 + ((isSetResult_msg()) ? 131071 : 524287);
    if (isSetResult_msg())
      hashCode = hashCode * 8191 + result_msg.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(OurMessage other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetMsg_flag()).compareTo(other.isSetMsg_flag());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMsg_flag()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.msg_flag, other.msg_flag);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetData_type()).compareTo(other.isSetData_type());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetData_type()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.data_type, other.data_type);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetData_body()).compareTo(other.isSetData_body());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetData_body()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.data_body, other.data_body);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetResult_msg()).compareTo(other.isSetResult_msg());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetResult_msg()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.result_msg, other.result_msg);
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
    StringBuilder sb = new StringBuilder("OurMessage(");
    boolean first = true;

    sb.append("msg_flag:");
    if (this.msg_flag == null) {
      sb.append("null");
    } else {
      sb.append(this.msg_flag);
    }
    first = false;
    if (isSetData_type()) {
      if (!first) sb.append(", ");
      sb.append("data_type:");
      if (this.data_type == null) {
        sb.append("null");
      } else {
        sb.append(this.data_type);
      }
      first = false;
    }
    if (isSetData_body()) {
      if (!first) sb.append(", ");
      sb.append("data_body:");
      if (this.data_body == null) {
        sb.append("null");
      } else {
        sb.append(this.data_body);
      }
      first = false;
    }
    if (isSetResult_msg()) {
      if (!first) sb.append(", ");
      sb.append("result_msg:");
      if (this.result_msg == null) {
        sb.append("null");
      } else {
        sb.append(this.result_msg);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (msg_flag == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'msg_flag' was not present! Struct: " + toString());
    }
    // check for sub-struct validity
    if (result_msg != null) {
      result_msg.validate();
    }
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

  private static class OurMessageStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public OurMessageStandardScheme getScheme() {
      return new OurMessageStandardScheme();
    }
  }

  private static class OurMessageStandardScheme extends org.apache.thrift.scheme.StandardScheme<OurMessage> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, OurMessage struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // MSG_FLAG
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.msg_flag = MsgFlag.findByValue(iprot.readI32());
              struct.setMsg_flagIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // DATA_TYPE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.data_type = DataType.findByValue(iprot.readI32());
              struct.setData_typeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // DATA_BODY
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.data_body = new DataBody();
              struct.data_body.read(iprot);
              struct.setData_bodyIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // RESULT_MSG
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.result_msg = new ResultMsg();
              struct.result_msg.read(iprot);
              struct.setResult_msgIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, OurMessage struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.msg_flag != null) {
        oprot.writeFieldBegin(MSG_FLAG_FIELD_DESC);
        oprot.writeI32(struct.msg_flag.getValue());
        oprot.writeFieldEnd();
      }
      if (struct.data_type != null) {
        if (struct.isSetData_type()) {
          oprot.writeFieldBegin(DATA_TYPE_FIELD_DESC);
          oprot.writeI32(struct.data_type.getValue());
          oprot.writeFieldEnd();
        }
      }
      if (struct.data_body != null) {
        if (struct.isSetData_body()) {
          oprot.writeFieldBegin(DATA_BODY_FIELD_DESC);
          struct.data_body.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      if (struct.result_msg != null) {
        if (struct.isSetResult_msg()) {
          oprot.writeFieldBegin(RESULT_MSG_FIELD_DESC);
          struct.result_msg.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class OurMessageTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public OurMessageTupleScheme getScheme() {
      return new OurMessageTupleScheme();
    }
  }

  private static class OurMessageTupleScheme extends org.apache.thrift.scheme.TupleScheme<OurMessage> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, OurMessage struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      oprot.writeI32(struct.msg_flag.getValue());
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetData_type()) {
        optionals.set(0);
      }
      if (struct.isSetData_body()) {
        optionals.set(1);
      }
      if (struct.isSetResult_msg()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetData_type()) {
        oprot.writeI32(struct.data_type.getValue());
      }
      if (struct.isSetData_body()) {
        struct.data_body.write(oprot);
      }
      if (struct.isSetResult_msg()) {
        struct.result_msg.write(oprot);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, OurMessage struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      struct.msg_flag = MsgFlag.findByValue(iprot.readI32());
      struct.setMsg_flagIsSet(true);
      java.util.BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        struct.data_type = DataType.findByValue(iprot.readI32());
        struct.setData_typeIsSet(true);
      }
      if (incoming.get(1)) {
        struct.data_body = new DataBody();
        struct.data_body.read(iprot);
        struct.setData_bodyIsSet(true);
      }
      if (incoming.get(2)) {
        struct.result_msg = new ResultMsg();
        struct.result_msg.read(iprot);
        struct.setResult_msgIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

