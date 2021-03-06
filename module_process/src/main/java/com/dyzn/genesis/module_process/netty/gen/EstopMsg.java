package com.dyzn.genesis.module_process.netty.gen;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.13.0)", date = "2020-08-27")
public class EstopMsg implements org.apache.thrift.TBase<EstopMsg, EstopMsg._Fields>, java.io.Serializable, Cloneable, Comparable<EstopMsg> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("EstopMsg");

  private static final org.apache.thrift.protocol.TField OPC_FIELD_DESC = new org.apache.thrift.protocol.TField("opc", org.apache.thrift.protocol.TType.I32, (short)1);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new EstopMsgStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new EstopMsgTupleSchemeFactory();

  public int opc; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    OPC((short)1, "opc");

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
        case 1: // OPC
          return OPC;
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
  private static final int __OPC_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.OPC, new org.apache.thrift.meta_data.FieldMetaData("opc", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(EstopMsg.class, metaDataMap);
  }

  public EstopMsg() {
  }

  public EstopMsg(
    int opc)
  {
    this();
    this.opc = opc;
    setOpcIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public EstopMsg(EstopMsg other) {
    __isset_bitfield = other.__isset_bitfield;
    this.opc = other.opc;
  }

  public EstopMsg deepCopy() {
    return new EstopMsg(this);
  }

  @Override
  public void clear() {
    setOpcIsSet(false);
    this.opc = 0;
  }

  public int getOpc() {
    return this.opc;
  }

  public EstopMsg setOpc(int opc) {
    this.opc = opc;
    setOpcIsSet(true);
    return this;
  }

  public void unsetOpc() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __OPC_ISSET_ID);
  }

  /** Returns true if field opc is set (has been assigned a value) and false otherwise */
  public boolean isSetOpc() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __OPC_ISSET_ID);
  }

  public void setOpcIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __OPC_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable Object value) {
    switch (field) {
    case OPC:
      if (value == null) {
        unsetOpc();
      } else {
        setOpc((Integer)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  public Object getFieldValue(_Fields field) {
    switch (field) {
    case OPC:
      return getOpc();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case OPC:
      return isSetOpc();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof EstopMsg)
      return this.equals((EstopMsg)that);
    return false;
  }

  public boolean equals(EstopMsg that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_opc = true;
    boolean that_present_opc = true;
    if (this_present_opc || that_present_opc) {
      if (!(this_present_opc && that_present_opc))
        return false;
      if (this.opc != that.opc)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + opc;

    return hashCode;
  }

  @Override
  public int compareTo(EstopMsg other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetOpc()).compareTo(other.isSetOpc());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetOpc()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.opc, other.opc);
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
    StringBuilder sb = new StringBuilder("EstopMsg(");
    boolean first = true;

    sb.append("opc:");
    sb.append(this.opc);
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
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class EstopMsgStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public EstopMsgStandardScheme getScheme() {
      return new EstopMsgStandardScheme();
    }
  }

  private static class EstopMsgStandardScheme extends org.apache.thrift.scheme.StandardScheme<EstopMsg> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, EstopMsg struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // OPC
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.opc = iprot.readI32();
              struct.setOpcIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, EstopMsg struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(OPC_FIELD_DESC);
      oprot.writeI32(struct.opc);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class EstopMsgTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public EstopMsgTupleScheme getScheme() {
      return new EstopMsgTupleScheme();
    }
  }

  private static class EstopMsgTupleScheme extends org.apache.thrift.scheme.TupleScheme<EstopMsg> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, EstopMsg struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetOpc()) {
        optionals.set(0);
      }
      oprot.writeBitSet(optionals, 1);
      if (struct.isSetOpc()) {
        oprot.writeI32(struct.opc);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, EstopMsg struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(1);
      if (incoming.get(0)) {
        struct.opc = iprot.readI32();
        struct.setOpcIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

