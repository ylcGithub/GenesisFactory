package com.dyzn.genesis.module_process.netty.gen;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.13.0)", date = "2020-08-27")
public class ResultMsg implements org.apache.thrift.TBase<ResultMsg, ResultMsg._Fields>, java.io.Serializable, Cloneable, Comparable<ResultMsg> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("ResultMsg");

  private static final org.apache.thrift.protocol.TField RESULT_FIELD_DESC = new org.apache.thrift.protocol.TField("result", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField ERR_CODE_FIELD_DESC = new org.apache.thrift.protocol.TField("errCode", org.apache.thrift.protocol.TType.I32, (short)2);
  private static final org.apache.thrift.protocol.TField REASON_FIELD_DESC = new org.apache.thrift.protocol.TField("reason", org.apache.thrift.protocol.TType.STRING, (short)3);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new ResultMsgStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new ResultMsgTupleSchemeFactory();

  /**
   * 
   * @see ResultType
   */
  public @org.apache.thrift.annotation.Nullable ResultType result; // required
  /**
   * 
   * @see ErrorCode
   */
  public @org.apache.thrift.annotation.Nullable ErrorCode errCode; // optional
  public @org.apache.thrift.annotation.Nullable String reason; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    /**
     * 
     * @see ResultType
     */
    RESULT((short)1, "result"),
    /**
     * 
     * @see ErrorCode
     */
    ERR_CODE((short)2, "errCode"),
    REASON((short)3, "reason");

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
        case 1: // RESULT
          return RESULT;
        case 2: // ERR_CODE
          return ERR_CODE;
        case 3: // REASON
          return REASON;
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
  private static final _Fields optionals[] = {_Fields.ERR_CODE, _Fields.REASON};
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.RESULT, new org.apache.thrift.meta_data.FieldMetaData("result", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, ResultType.class)));
    tmpMap.put(_Fields.ERR_CODE, new org.apache.thrift.meta_data.FieldMetaData("errCode", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, ErrorCode.class)));
    tmpMap.put(_Fields.REASON, new org.apache.thrift.meta_data.FieldMetaData("reason", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(ResultMsg.class, metaDataMap);
  }

  public ResultMsg() {
  }

  public ResultMsg(
    ResultType result)
  {
    this();
    this.result = result;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public ResultMsg(ResultMsg other) {
    if (other.isSetResult()) {
      this.result = other.result;
    }
    if (other.isSetErrCode()) {
      this.errCode = other.errCode;
    }
    if (other.isSetReason()) {
      this.reason = other.reason;
    }
  }

  public ResultMsg deepCopy() {
    return new ResultMsg(this);
  }

  @Override
  public void clear() {
    this.result = null;
    this.errCode = null;
    this.reason = null;
  }

  /**
   * 
   * @see ResultType
   */
  @org.apache.thrift.annotation.Nullable
  public ResultType getResult() {
    return this.result;
  }

  /**
   * 
   * @see ResultType
   */
  public ResultMsg setResult(@org.apache.thrift.annotation.Nullable ResultType result) {
    this.result = result;
    return this;
  }

  public void unsetResult() {
    this.result = null;
  }

  /** Returns true if field result is set (has been assigned a value) and false otherwise */
  public boolean isSetResult() {
    return this.result != null;
  }

  public void setResultIsSet(boolean value) {
    if (!value) {
      this.result = null;
    }
  }

  /**
   * 
   * @see ErrorCode
   */
  @org.apache.thrift.annotation.Nullable
  public ErrorCode getErrCode() {
    return this.errCode;
  }

  /**
   * 
   * @see ErrorCode
   */
  public ResultMsg setErrCode(@org.apache.thrift.annotation.Nullable ErrorCode errCode) {
    this.errCode = errCode;
    return this;
  }

  public void unsetErrCode() {
    this.errCode = null;
  }

  /** Returns true if field errCode is set (has been assigned a value) and false otherwise */
  public boolean isSetErrCode() {
    return this.errCode != null;
  }

  public void setErrCodeIsSet(boolean value) {
    if (!value) {
      this.errCode = null;
    }
  }

  @org.apache.thrift.annotation.Nullable
  public String getReason() {
    return this.reason;
  }

  public ResultMsg setReason(@org.apache.thrift.annotation.Nullable String reason) {
    this.reason = reason;
    return this;
  }

  public void unsetReason() {
    this.reason = null;
  }

  /** Returns true if field reason is set (has been assigned a value) and false otherwise */
  public boolean isSetReason() {
    return this.reason != null;
  }

  public void setReasonIsSet(boolean value) {
    if (!value) {
      this.reason = null;
    }
  }

  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable Object value) {
    switch (field) {
    case RESULT:
      if (value == null) {
        unsetResult();
      } else {
        setResult((ResultType)value);
      }
      break;

    case ERR_CODE:
      if (value == null) {
        unsetErrCode();
      } else {
        setErrCode((ErrorCode)value);
      }
      break;

    case REASON:
      if (value == null) {
        unsetReason();
      } else {
        setReason((String)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  public Object getFieldValue(_Fields field) {
    switch (field) {
    case RESULT:
      return getResult();

    case ERR_CODE:
      return getErrCode();

    case REASON:
      return getReason();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case RESULT:
      return isSetResult();
    case ERR_CODE:
      return isSetErrCode();
    case REASON:
      return isSetReason();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof ResultMsg)
      return this.equals((ResultMsg)that);
    return false;
  }

  public boolean equals(ResultMsg that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_result = true && this.isSetResult();
    boolean that_present_result = true && that.isSetResult();
    if (this_present_result || that_present_result) {
      if (!(this_present_result && that_present_result))
        return false;
      if (!this.result.equals(that.result))
        return false;
    }

    boolean this_present_errCode = true && this.isSetErrCode();
    boolean that_present_errCode = true && that.isSetErrCode();
    if (this_present_errCode || that_present_errCode) {
      if (!(this_present_errCode && that_present_errCode))
        return false;
      if (!this.errCode.equals(that.errCode))
        return false;
    }

    boolean this_present_reason = true && this.isSetReason();
    boolean that_present_reason = true && that.isSetReason();
    if (this_present_reason || that_present_reason) {
      if (!(this_present_reason && that_present_reason))
        return false;
      if (!this.reason.equals(that.reason))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetResult()) ? 131071 : 524287);
    if (isSetResult())
      hashCode = hashCode * 8191 + result.getValue();

    hashCode = hashCode * 8191 + ((isSetErrCode()) ? 131071 : 524287);
    if (isSetErrCode())
      hashCode = hashCode * 8191 + errCode.getValue();

    hashCode = hashCode * 8191 + ((isSetReason()) ? 131071 : 524287);
    if (isSetReason())
      hashCode = hashCode * 8191 + reason.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(ResultMsg other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetResult()).compareTo(other.isSetResult());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetResult()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.result, other.result);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetErrCode()).compareTo(other.isSetErrCode());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetErrCode()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.errCode, other.errCode);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetReason()).compareTo(other.isSetReason());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetReason()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.reason, other.reason);
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
    StringBuilder sb = new StringBuilder("ResultMsg(");
    boolean first = true;

    sb.append("result:");
    if (this.result == null) {
      sb.append("null");
    } else {
      sb.append(this.result);
    }
    first = false;
    if (isSetErrCode()) {
      if (!first) sb.append(", ");
      sb.append("errCode:");
      if (this.errCode == null) {
        sb.append("null");
      } else {
        sb.append(this.errCode);
      }
      first = false;
    }
    if (isSetReason()) {
      if (!first) sb.append(", ");
      sb.append("reason:");
      if (this.reason == null) {
        sb.append("null");
      } else {
        sb.append(this.reason);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (result == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'result' was not present! Struct: " + toString());
    }
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

  private static class ResultMsgStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public ResultMsgStandardScheme getScheme() {
      return new ResultMsgStandardScheme();
    }
  }

  private static class ResultMsgStandardScheme extends org.apache.thrift.scheme.StandardScheme<ResultMsg> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, ResultMsg struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // RESULT
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.result = ResultType.findByValue(iprot.readI32());
              struct.setResultIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // ERR_CODE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.errCode = ErrorCode.findByValue(iprot.readI32());
              struct.setErrCodeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // REASON
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.reason = iprot.readString();
              struct.setReasonIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, ResultMsg struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.result != null) {
        oprot.writeFieldBegin(RESULT_FIELD_DESC);
        oprot.writeI32(struct.result.getValue());
        oprot.writeFieldEnd();
      }
      if (struct.errCode != null) {
        if (struct.isSetErrCode()) {
          oprot.writeFieldBegin(ERR_CODE_FIELD_DESC);
          oprot.writeI32(struct.errCode.getValue());
          oprot.writeFieldEnd();
        }
      }
      if (struct.reason != null) {
        if (struct.isSetReason()) {
          oprot.writeFieldBegin(REASON_FIELD_DESC);
          oprot.writeString(struct.reason);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class ResultMsgTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public ResultMsgTupleScheme getScheme() {
      return new ResultMsgTupleScheme();
    }
  }

  private static class ResultMsgTupleScheme extends org.apache.thrift.scheme.TupleScheme<ResultMsg> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, ResultMsg struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      oprot.writeI32(struct.result.getValue());
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetErrCode()) {
        optionals.set(0);
      }
      if (struct.isSetReason()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetErrCode()) {
        oprot.writeI32(struct.errCode.getValue());
      }
      if (struct.isSetReason()) {
        oprot.writeString(struct.reason);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, ResultMsg struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      struct.result = ResultType.findByValue(iprot.readI32());
      struct.setResultIsSet(true);
      java.util.BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        struct.errCode = ErrorCode.findByValue(iprot.readI32());
        struct.setErrCodeIsSet(true);
      }
      if (incoming.get(1)) {
        struct.reason = iprot.readString();
        struct.setReasonIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}
