package com.dyzn.genesis.module_process.netty.gen;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.13.0)", date = "2020-08-27")
public class MPGMsg implements org.apache.thrift.TBase<MPGMsg, MPGMsg._Fields>, java.io.Serializable, Cloneable, Comparable<MPGMsg> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("MPGMsg");

  private static final org.apache.thrift.protocol.TField DIR_FIELD_DESC = new org.apache.thrift.protocol.TField("dir", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField AXIS_FIELD_DESC = new org.apache.thrift.protocol.TField("axis", org.apache.thrift.protocol.TType.I32, (short)2);
  private static final org.apache.thrift.protocol.TField UP_OR_DOWN_FIELD_DESC = new org.apache.thrift.protocol.TField("upOrDown", org.apache.thrift.protocol.TType.I32, (short)3);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new MPGMsgStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new MPGMsgTupleSchemeFactory();

  public int dir; // required
  public int axis; // required
  public int upOrDown; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    DIR((short)1, "dir"),
    AXIS((short)2, "axis"),
    UP_OR_DOWN((short)3, "upOrDown");

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
        case 1: // DIR
          return DIR;
        case 2: // AXIS
          return AXIS;
        case 3: // UP_OR_DOWN
          return UP_OR_DOWN;
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
  private static final int __DIR_ISSET_ID = 0;
  private static final int __AXIS_ISSET_ID = 1;
  private static final int __UPORDOWN_ISSET_ID = 2;
  private byte __isset_bitfield = 0;
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.DIR, new org.apache.thrift.meta_data.FieldMetaData("dir", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.AXIS, new org.apache.thrift.meta_data.FieldMetaData("axis", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.UP_OR_DOWN, new org.apache.thrift.meta_data.FieldMetaData("upOrDown", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(MPGMsg.class, metaDataMap);
  }

  public MPGMsg() {
  }

  public MPGMsg(
    int dir,
    int axis,
    int upOrDown)
  {
    this();
    this.dir = dir;
    setDirIsSet(true);
    this.axis = axis;
    setAxisIsSet(true);
    this.upOrDown = upOrDown;
    setUpOrDownIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public MPGMsg(MPGMsg other) {
    __isset_bitfield = other.__isset_bitfield;
    this.dir = other.dir;
    this.axis = other.axis;
    this.upOrDown = other.upOrDown;
  }

  public MPGMsg deepCopy() {
    return new MPGMsg(this);
  }

  @Override
  public void clear() {
    setDirIsSet(false);
    this.dir = 0;
    setAxisIsSet(false);
    this.axis = 0;
    setUpOrDownIsSet(false);
    this.upOrDown = 0;
  }

  public int getDir() {
    return this.dir;
  }

  public MPGMsg setDir(int dir) {
    this.dir = dir;
    setDirIsSet(true);
    return this;
  }

  public void unsetDir() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __DIR_ISSET_ID);
  }

  /** Returns true if field dir is set (has been assigned a value) and false otherwise */
  public boolean isSetDir() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __DIR_ISSET_ID);
  }

  public void setDirIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __DIR_ISSET_ID, value);
  }

  public int getAxis() {
    return this.axis;
  }

  public MPGMsg setAxis(int axis) {
    this.axis = axis;
    setAxisIsSet(true);
    return this;
  }

  public void unsetAxis() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __AXIS_ISSET_ID);
  }

  /** Returns true if field axis is set (has been assigned a value) and false otherwise */
  public boolean isSetAxis() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __AXIS_ISSET_ID);
  }

  public void setAxisIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __AXIS_ISSET_ID, value);
  }

  public int getUpOrDown() {
    return this.upOrDown;
  }

  public MPGMsg setUpOrDown(int upOrDown) {
    this.upOrDown = upOrDown;
    setUpOrDownIsSet(true);
    return this;
  }

  public void unsetUpOrDown() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __UPORDOWN_ISSET_ID);
  }

  /** Returns true if field upOrDown is set (has been assigned a value) and false otherwise */
  public boolean isSetUpOrDown() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __UPORDOWN_ISSET_ID);
  }

  public void setUpOrDownIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __UPORDOWN_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable Object value) {
    switch (field) {
    case DIR:
      if (value == null) {
        unsetDir();
      } else {
        setDir((Integer)value);
      }
      break;

    case AXIS:
      if (value == null) {
        unsetAxis();
      } else {
        setAxis((Integer)value);
      }
      break;

    case UP_OR_DOWN:
      if (value == null) {
        unsetUpOrDown();
      } else {
        setUpOrDown((Integer)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  public Object getFieldValue(_Fields field) {
    switch (field) {
    case DIR:
      return getDir();

    case AXIS:
      return getAxis();

    case UP_OR_DOWN:
      return getUpOrDown();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case DIR:
      return isSetDir();
    case AXIS:
      return isSetAxis();
    case UP_OR_DOWN:
      return isSetUpOrDown();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof MPGMsg)
      return this.equals((MPGMsg)that);
    return false;
  }

  public boolean equals(MPGMsg that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_dir = true;
    boolean that_present_dir = true;
    if (this_present_dir || that_present_dir) {
      if (!(this_present_dir && that_present_dir))
        return false;
      if (this.dir != that.dir)
        return false;
    }

    boolean this_present_axis = true;
    boolean that_present_axis = true;
    if (this_present_axis || that_present_axis) {
      if (!(this_present_axis && that_present_axis))
        return false;
      if (this.axis != that.axis)
        return false;
    }

    boolean this_present_upOrDown = true;
    boolean that_present_upOrDown = true;
    if (this_present_upOrDown || that_present_upOrDown) {
      if (!(this_present_upOrDown && that_present_upOrDown))
        return false;
      if (this.upOrDown != that.upOrDown)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + dir;

    hashCode = hashCode * 8191 + axis;

    hashCode = hashCode * 8191 + upOrDown;

    return hashCode;
  }

  @Override
  public int compareTo(MPGMsg other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetDir()).compareTo(other.isSetDir());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDir()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.dir, other.dir);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetAxis()).compareTo(other.isSetAxis());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAxis()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.axis, other.axis);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetUpOrDown()).compareTo(other.isSetUpOrDown());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetUpOrDown()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.upOrDown, other.upOrDown);
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
    StringBuilder sb = new StringBuilder("MPGMsg(");
    boolean first = true;

    sb.append("dir:");
    sb.append(this.dir);
    first = false;
    if (!first) sb.append(", ");
    sb.append("axis:");
    sb.append(this.axis);
    first = false;
    if (!first) sb.append(", ");
    sb.append("upOrDown:");
    sb.append(this.upOrDown);
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

  private static class MPGMsgStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public MPGMsgStandardScheme getScheme() {
      return new MPGMsgStandardScheme();
    }
  }

  private static class MPGMsgStandardScheme extends org.apache.thrift.scheme.StandardScheme<MPGMsg> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, MPGMsg struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // DIR
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.dir = iprot.readI32();
              struct.setDirIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // AXIS
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.axis = iprot.readI32();
              struct.setAxisIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // UP_OR_DOWN
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.upOrDown = iprot.readI32();
              struct.setUpOrDownIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, MPGMsg struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(DIR_FIELD_DESC);
      oprot.writeI32(struct.dir);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(AXIS_FIELD_DESC);
      oprot.writeI32(struct.axis);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(UP_OR_DOWN_FIELD_DESC);
      oprot.writeI32(struct.upOrDown);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class MPGMsgTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public MPGMsgTupleScheme getScheme() {
      return new MPGMsgTupleScheme();
    }
  }

  private static class MPGMsgTupleScheme extends org.apache.thrift.scheme.TupleScheme<MPGMsg> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, MPGMsg struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetDir()) {
        optionals.set(0);
      }
      if (struct.isSetAxis()) {
        optionals.set(1);
      }
      if (struct.isSetUpOrDown()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetDir()) {
        oprot.writeI32(struct.dir);
      }
      if (struct.isSetAxis()) {
        oprot.writeI32(struct.axis);
      }
      if (struct.isSetUpOrDown()) {
        oprot.writeI32(struct.upOrDown);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, MPGMsg struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        struct.dir = iprot.readI32();
        struct.setDirIsSet(true);
      }
      if (incoming.get(1)) {
        struct.axis = iprot.readI32();
        struct.setAxisIsSet(true);
      }
      if (incoming.get(2)) {
        struct.upOrDown = iprot.readI32();
        struct.setUpOrDownIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

