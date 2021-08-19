package com.dyzn.genesis.module_process.netty.gen;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.13.0)", date = "2020-08-27")
public class SetActualCoordMsg implements org.apache.thrift.TBase<SetActualCoordMsg, SetActualCoordMsg._Fields>, java.io.Serializable, Cloneable, Comparable<SetActualCoordMsg> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("SetActualCoordMsg");

  private static final org.apache.thrift.protocol.TField AXIS1_FIELD_DESC = new org.apache.thrift.protocol.TField("axis1", org.apache.thrift.protocol.TType.DOUBLE, (short)1);
  private static final org.apache.thrift.protocol.TField AXIS2_FIELD_DESC = new org.apache.thrift.protocol.TField("axis2", org.apache.thrift.protocol.TType.DOUBLE, (short)2);
  private static final org.apache.thrift.protocol.TField AXIS3_FIELD_DESC = new org.apache.thrift.protocol.TField("axis3", org.apache.thrift.protocol.TType.DOUBLE, (short)3);
  private static final org.apache.thrift.protocol.TField AXIS4_FIELD_DESC = new org.apache.thrift.protocol.TField("axis4", org.apache.thrift.protocol.TType.DOUBLE, (short)4);
  private static final org.apache.thrift.protocol.TField AXIS5_FIELD_DESC = new org.apache.thrift.protocol.TField("axis5", org.apache.thrift.protocol.TType.DOUBLE, (short)5);
  private static final org.apache.thrift.protocol.TField AXIS6_FIELD_DESC = new org.apache.thrift.protocol.TField("axis6", org.apache.thrift.protocol.TType.DOUBLE, (short)6);
  private static final org.apache.thrift.protocol.TField AXIS7_FIELD_DESC = new org.apache.thrift.protocol.TField("axis7", org.apache.thrift.protocol.TType.DOUBLE, (short)7);
  private static final org.apache.thrift.protocol.TField AXIS8_FIELD_DESC = new org.apache.thrift.protocol.TField("axis8", org.apache.thrift.protocol.TType.DOUBLE, (short)8);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new SetActualCoordMsgStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new SetActualCoordMsgTupleSchemeFactory();

  public double axis1; // required
  public double axis2; // required
  public double axis3; // required
  public double axis4; // required
  public double axis5; // required
  public double axis6; // required
  public double axis7; // required
  public double axis8; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    AXIS1((short)1, "axis1"),
    AXIS2((short)2, "axis2"),
    AXIS3((short)3, "axis3"),
    AXIS4((short)4, "axis4"),
    AXIS5((short)5, "axis5"),
    AXIS6((short)6, "axis6"),
    AXIS7((short)7, "axis7"),
    AXIS8((short)8, "axis8");

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
        case 1: // AXIS1
          return AXIS1;
        case 2: // AXIS2
          return AXIS2;
        case 3: // AXIS3
          return AXIS3;
        case 4: // AXIS4
          return AXIS4;
        case 5: // AXIS5
          return AXIS5;
        case 6: // AXIS6
          return AXIS6;
        case 7: // AXIS7
          return AXIS7;
        case 8: // AXIS8
          return AXIS8;
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
  private static final int __AXIS1_ISSET_ID = 0;
  private static final int __AXIS2_ISSET_ID = 1;
  private static final int __AXIS3_ISSET_ID = 2;
  private static final int __AXIS4_ISSET_ID = 3;
  private static final int __AXIS5_ISSET_ID = 4;
  private static final int __AXIS6_ISSET_ID = 5;
  private static final int __AXIS7_ISSET_ID = 6;
  private static final int __AXIS8_ISSET_ID = 7;
  private byte __isset_bitfield = 0;
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.AXIS1, new org.apache.thrift.meta_data.FieldMetaData("axis1", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
    tmpMap.put(_Fields.AXIS2, new org.apache.thrift.meta_data.FieldMetaData("axis2", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
    tmpMap.put(_Fields.AXIS3, new org.apache.thrift.meta_data.FieldMetaData("axis3", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
    tmpMap.put(_Fields.AXIS4, new org.apache.thrift.meta_data.FieldMetaData("axis4", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
    tmpMap.put(_Fields.AXIS5, new org.apache.thrift.meta_data.FieldMetaData("axis5", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
    tmpMap.put(_Fields.AXIS6, new org.apache.thrift.meta_data.FieldMetaData("axis6", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
    tmpMap.put(_Fields.AXIS7, new org.apache.thrift.meta_data.FieldMetaData("axis7", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
    tmpMap.put(_Fields.AXIS8, new org.apache.thrift.meta_data.FieldMetaData("axis8", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(SetActualCoordMsg.class, metaDataMap);
  }

  public SetActualCoordMsg() {
  }

  public SetActualCoordMsg(
    double axis1,
    double axis2,
    double axis3,
    double axis4,
    double axis5,
    double axis6,
    double axis7,
    double axis8)
  {
    this();
    this.axis1 = axis1;
    setAxis1IsSet(true);
    this.axis2 = axis2;
    setAxis2IsSet(true);
    this.axis3 = axis3;
    setAxis3IsSet(true);
    this.axis4 = axis4;
    setAxis4IsSet(true);
    this.axis5 = axis5;
    setAxis5IsSet(true);
    this.axis6 = axis6;
    setAxis6IsSet(true);
    this.axis7 = axis7;
    setAxis7IsSet(true);
    this.axis8 = axis8;
    setAxis8IsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public SetActualCoordMsg(SetActualCoordMsg other) {
    __isset_bitfield = other.__isset_bitfield;
    this.axis1 = other.axis1;
    this.axis2 = other.axis2;
    this.axis3 = other.axis3;
    this.axis4 = other.axis4;
    this.axis5 = other.axis5;
    this.axis6 = other.axis6;
    this.axis7 = other.axis7;
    this.axis8 = other.axis8;
  }

  public SetActualCoordMsg deepCopy() {
    return new SetActualCoordMsg(this);
  }

  @Override
  public void clear() {
    setAxis1IsSet(false);
    this.axis1 = 0.0;
    setAxis2IsSet(false);
    this.axis2 = 0.0;
    setAxis3IsSet(false);
    this.axis3 = 0.0;
    setAxis4IsSet(false);
    this.axis4 = 0.0;
    setAxis5IsSet(false);
    this.axis5 = 0.0;
    setAxis6IsSet(false);
    this.axis6 = 0.0;
    setAxis7IsSet(false);
    this.axis7 = 0.0;
    setAxis8IsSet(false);
    this.axis8 = 0.0;
  }

  public double getAxis1() {
    return this.axis1;
  }

  public SetActualCoordMsg setAxis1(double axis1) {
    this.axis1 = axis1;
    setAxis1IsSet(true);
    return this;
  }

  public void unsetAxis1() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __AXIS1_ISSET_ID);
  }

  /** Returns true if field axis1 is set (has been assigned a value) and false otherwise */
  public boolean isSetAxis1() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __AXIS1_ISSET_ID);
  }

  public void setAxis1IsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __AXIS1_ISSET_ID, value);
  }

  public double getAxis2() {
    return this.axis2;
  }

  public SetActualCoordMsg setAxis2(double axis2) {
    this.axis2 = axis2;
    setAxis2IsSet(true);
    return this;
  }

  public void unsetAxis2() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __AXIS2_ISSET_ID);
  }

  /** Returns true if field axis2 is set (has been assigned a value) and false otherwise */
  public boolean isSetAxis2() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __AXIS2_ISSET_ID);
  }

  public void setAxis2IsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __AXIS2_ISSET_ID, value);
  }

  public double getAxis3() {
    return this.axis3;
  }

  public SetActualCoordMsg setAxis3(double axis3) {
    this.axis3 = axis3;
    setAxis3IsSet(true);
    return this;
  }

  public void unsetAxis3() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __AXIS3_ISSET_ID);
  }

  /** Returns true if field axis3 is set (has been assigned a value) and false otherwise */
  public boolean isSetAxis3() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __AXIS3_ISSET_ID);
  }

  public void setAxis3IsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __AXIS3_ISSET_ID, value);
  }

  public double getAxis4() {
    return this.axis4;
  }

  public SetActualCoordMsg setAxis4(double axis4) {
    this.axis4 = axis4;
    setAxis4IsSet(true);
    return this;
  }

  public void unsetAxis4() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __AXIS4_ISSET_ID);
  }

  /** Returns true if field axis4 is set (has been assigned a value) and false otherwise */
  public boolean isSetAxis4() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __AXIS4_ISSET_ID);
  }

  public void setAxis4IsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __AXIS4_ISSET_ID, value);
  }

  public double getAxis5() {
    return this.axis5;
  }

  public SetActualCoordMsg setAxis5(double axis5) {
    this.axis5 = axis5;
    setAxis5IsSet(true);
    return this;
  }

  public void unsetAxis5() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __AXIS5_ISSET_ID);
  }

  /** Returns true if field axis5 is set (has been assigned a value) and false otherwise */
  public boolean isSetAxis5() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __AXIS5_ISSET_ID);
  }

  public void setAxis5IsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __AXIS5_ISSET_ID, value);
  }

  public double getAxis6() {
    return this.axis6;
  }

  public SetActualCoordMsg setAxis6(double axis6) {
    this.axis6 = axis6;
    setAxis6IsSet(true);
    return this;
  }

  public void unsetAxis6() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __AXIS6_ISSET_ID);
  }

  /** Returns true if field axis6 is set (has been assigned a value) and false otherwise */
  public boolean isSetAxis6() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __AXIS6_ISSET_ID);
  }

  public void setAxis6IsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __AXIS6_ISSET_ID, value);
  }

  public double getAxis7() {
    return this.axis7;
  }

  public SetActualCoordMsg setAxis7(double axis7) {
    this.axis7 = axis7;
    setAxis7IsSet(true);
    return this;
  }

  public void unsetAxis7() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __AXIS7_ISSET_ID);
  }

  /** Returns true if field axis7 is set (has been assigned a value) and false otherwise */
  public boolean isSetAxis7() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __AXIS7_ISSET_ID);
  }

  public void setAxis7IsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __AXIS7_ISSET_ID, value);
  }

  public double getAxis8() {
    return this.axis8;
  }

  public SetActualCoordMsg setAxis8(double axis8) {
    this.axis8 = axis8;
    setAxis8IsSet(true);
    return this;
  }

  public void unsetAxis8() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __AXIS8_ISSET_ID);
  }

  /** Returns true if field axis8 is set (has been assigned a value) and false otherwise */
  public boolean isSetAxis8() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __AXIS8_ISSET_ID);
  }

  public void setAxis8IsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __AXIS8_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable Object value) {
    switch (field) {
    case AXIS1:
      if (value == null) {
        unsetAxis1();
      } else {
        setAxis1((Double)value);
      }
      break;

    case AXIS2:
      if (value == null) {
        unsetAxis2();
      } else {
        setAxis2((Double)value);
      }
      break;

    case AXIS3:
      if (value == null) {
        unsetAxis3();
      } else {
        setAxis3((Double)value);
      }
      break;

    case AXIS4:
      if (value == null) {
        unsetAxis4();
      } else {
        setAxis4((Double)value);
      }
      break;

    case AXIS5:
      if (value == null) {
        unsetAxis5();
      } else {
        setAxis5((Double)value);
      }
      break;

    case AXIS6:
      if (value == null) {
        unsetAxis6();
      } else {
        setAxis6((Double)value);
      }
      break;

    case AXIS7:
      if (value == null) {
        unsetAxis7();
      } else {
        setAxis7((Double)value);
      }
      break;

    case AXIS8:
      if (value == null) {
        unsetAxis8();
      } else {
        setAxis8((Double)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  public Object getFieldValue(_Fields field) {
    switch (field) {
    case AXIS1:
      return getAxis1();

    case AXIS2:
      return getAxis2();

    case AXIS3:
      return getAxis3();

    case AXIS4:
      return getAxis4();

    case AXIS5:
      return getAxis5();

    case AXIS6:
      return getAxis6();

    case AXIS7:
      return getAxis7();

    case AXIS8:
      return getAxis8();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case AXIS1:
      return isSetAxis1();
    case AXIS2:
      return isSetAxis2();
    case AXIS3:
      return isSetAxis3();
    case AXIS4:
      return isSetAxis4();
    case AXIS5:
      return isSetAxis5();
    case AXIS6:
      return isSetAxis6();
    case AXIS7:
      return isSetAxis7();
    case AXIS8:
      return isSetAxis8();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof SetActualCoordMsg)
      return this.equals((SetActualCoordMsg)that);
    return false;
  }

  public boolean equals(SetActualCoordMsg that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_axis1 = true;
    boolean that_present_axis1 = true;
    if (this_present_axis1 || that_present_axis1) {
      if (!(this_present_axis1 && that_present_axis1))
        return false;
      if (this.axis1 != that.axis1)
        return false;
    }

    boolean this_present_axis2 = true;
    boolean that_present_axis2 = true;
    if (this_present_axis2 || that_present_axis2) {
      if (!(this_present_axis2 && that_present_axis2))
        return false;
      if (this.axis2 != that.axis2)
        return false;
    }

    boolean this_present_axis3 = true;
    boolean that_present_axis3 = true;
    if (this_present_axis3 || that_present_axis3) {
      if (!(this_present_axis3 && that_present_axis3))
        return false;
      if (this.axis3 != that.axis3)
        return false;
    }

    boolean this_present_axis4 = true;
    boolean that_present_axis4 = true;
    if (this_present_axis4 || that_present_axis4) {
      if (!(this_present_axis4 && that_present_axis4))
        return false;
      if (this.axis4 != that.axis4)
        return false;
    }

    boolean this_present_axis5 = true;
    boolean that_present_axis5 = true;
    if (this_present_axis5 || that_present_axis5) {
      if (!(this_present_axis5 && that_present_axis5))
        return false;
      if (this.axis5 != that.axis5)
        return false;
    }

    boolean this_present_axis6 = true;
    boolean that_present_axis6 = true;
    if (this_present_axis6 || that_present_axis6) {
      if (!(this_present_axis6 && that_present_axis6))
        return false;
      if (this.axis6 != that.axis6)
        return false;
    }

    boolean this_present_axis7 = true;
    boolean that_present_axis7 = true;
    if (this_present_axis7 || that_present_axis7) {
      if (!(this_present_axis7 && that_present_axis7))
        return false;
      if (this.axis7 != that.axis7)
        return false;
    }

    boolean this_present_axis8 = true;
    boolean that_present_axis8 = true;
    if (this_present_axis8 || that_present_axis8) {
      if (!(this_present_axis8 && that_present_axis8))
        return false;
      if (this.axis8 != that.axis8)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(axis1);

    hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(axis2);

    hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(axis3);

    hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(axis4);

    hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(axis5);

    hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(axis6);

    hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(axis7);

    hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(axis8);

    return hashCode;
  }

  @Override
  public int compareTo(SetActualCoordMsg other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetAxis1()).compareTo(other.isSetAxis1());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAxis1()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.axis1, other.axis1);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetAxis2()).compareTo(other.isSetAxis2());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAxis2()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.axis2, other.axis2);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetAxis3()).compareTo(other.isSetAxis3());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAxis3()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.axis3, other.axis3);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetAxis4()).compareTo(other.isSetAxis4());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAxis4()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.axis4, other.axis4);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetAxis5()).compareTo(other.isSetAxis5());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAxis5()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.axis5, other.axis5);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetAxis6()).compareTo(other.isSetAxis6());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAxis6()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.axis6, other.axis6);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetAxis7()).compareTo(other.isSetAxis7());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAxis7()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.axis7, other.axis7);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetAxis8()).compareTo(other.isSetAxis8());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAxis8()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.axis8, other.axis8);
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
    StringBuilder sb = new StringBuilder("SetActualCoordMsg(");
    boolean first = true;

    sb.append("axis1:");
    sb.append(this.axis1);
    first = false;
    if (!first) sb.append(", ");
    sb.append("axis2:");
    sb.append(this.axis2);
    first = false;
    if (!first) sb.append(", ");
    sb.append("axis3:");
    sb.append(this.axis3);
    first = false;
    if (!first) sb.append(", ");
    sb.append("axis4:");
    sb.append(this.axis4);
    first = false;
    if (!first) sb.append(", ");
    sb.append("axis5:");
    sb.append(this.axis5);
    first = false;
    if (!first) sb.append(", ");
    sb.append("axis6:");
    sb.append(this.axis6);
    first = false;
    if (!first) sb.append(", ");
    sb.append("axis7:");
    sb.append(this.axis7);
    first = false;
    if (!first) sb.append(", ");
    sb.append("axis8:");
    sb.append(this.axis8);
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

  private static class SetActualCoordMsgStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public SetActualCoordMsgStandardScheme getScheme() {
      return new SetActualCoordMsgStandardScheme();
    }
  }

  private static class SetActualCoordMsgStandardScheme extends org.apache.thrift.scheme.StandardScheme<SetActualCoordMsg> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, SetActualCoordMsg struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // AXIS1
            if (schemeField.type == org.apache.thrift.protocol.TType.DOUBLE) {
              struct.axis1 = iprot.readDouble();
              struct.setAxis1IsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // AXIS2
            if (schemeField.type == org.apache.thrift.protocol.TType.DOUBLE) {
              struct.axis2 = iprot.readDouble();
              struct.setAxis2IsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // AXIS3
            if (schemeField.type == org.apache.thrift.protocol.TType.DOUBLE) {
              struct.axis3 = iprot.readDouble();
              struct.setAxis3IsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // AXIS4
            if (schemeField.type == org.apache.thrift.protocol.TType.DOUBLE) {
              struct.axis4 = iprot.readDouble();
              struct.setAxis4IsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // AXIS5
            if (schemeField.type == org.apache.thrift.protocol.TType.DOUBLE) {
              struct.axis5 = iprot.readDouble();
              struct.setAxis5IsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // AXIS6
            if (schemeField.type == org.apache.thrift.protocol.TType.DOUBLE) {
              struct.axis6 = iprot.readDouble();
              struct.setAxis6IsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 7: // AXIS7
            if (schemeField.type == org.apache.thrift.protocol.TType.DOUBLE) {
              struct.axis7 = iprot.readDouble();
              struct.setAxis7IsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 8: // AXIS8
            if (schemeField.type == org.apache.thrift.protocol.TType.DOUBLE) {
              struct.axis8 = iprot.readDouble();
              struct.setAxis8IsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, SetActualCoordMsg struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(AXIS1_FIELD_DESC);
      oprot.writeDouble(struct.axis1);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(AXIS2_FIELD_DESC);
      oprot.writeDouble(struct.axis2);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(AXIS3_FIELD_DESC);
      oprot.writeDouble(struct.axis3);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(AXIS4_FIELD_DESC);
      oprot.writeDouble(struct.axis4);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(AXIS5_FIELD_DESC);
      oprot.writeDouble(struct.axis5);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(AXIS6_FIELD_DESC);
      oprot.writeDouble(struct.axis6);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(AXIS7_FIELD_DESC);
      oprot.writeDouble(struct.axis7);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(AXIS8_FIELD_DESC);
      oprot.writeDouble(struct.axis8);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class SetActualCoordMsgTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public SetActualCoordMsgTupleScheme getScheme() {
      return new SetActualCoordMsgTupleScheme();
    }
  }

  private static class SetActualCoordMsgTupleScheme extends org.apache.thrift.scheme.TupleScheme<SetActualCoordMsg> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, SetActualCoordMsg struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetAxis1()) {
        optionals.set(0);
      }
      if (struct.isSetAxis2()) {
        optionals.set(1);
      }
      if (struct.isSetAxis3()) {
        optionals.set(2);
      }
      if (struct.isSetAxis4()) {
        optionals.set(3);
      }
      if (struct.isSetAxis5()) {
        optionals.set(4);
      }
      if (struct.isSetAxis6()) {
        optionals.set(5);
      }
      if (struct.isSetAxis7()) {
        optionals.set(6);
      }
      if (struct.isSetAxis8()) {
        optionals.set(7);
      }
      oprot.writeBitSet(optionals, 8);
      if (struct.isSetAxis1()) {
        oprot.writeDouble(struct.axis1);
      }
      if (struct.isSetAxis2()) {
        oprot.writeDouble(struct.axis2);
      }
      if (struct.isSetAxis3()) {
        oprot.writeDouble(struct.axis3);
      }
      if (struct.isSetAxis4()) {
        oprot.writeDouble(struct.axis4);
      }
      if (struct.isSetAxis5()) {
        oprot.writeDouble(struct.axis5);
      }
      if (struct.isSetAxis6()) {
        oprot.writeDouble(struct.axis6);
      }
      if (struct.isSetAxis7()) {
        oprot.writeDouble(struct.axis7);
      }
      if (struct.isSetAxis8()) {
        oprot.writeDouble(struct.axis8);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, SetActualCoordMsg struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(8);
      if (incoming.get(0)) {
        struct.axis1 = iprot.readDouble();
        struct.setAxis1IsSet(true);
      }
      if (incoming.get(1)) {
        struct.axis2 = iprot.readDouble();
        struct.setAxis2IsSet(true);
      }
      if (incoming.get(2)) {
        struct.axis3 = iprot.readDouble();
        struct.setAxis3IsSet(true);
      }
      if (incoming.get(3)) {
        struct.axis4 = iprot.readDouble();
        struct.setAxis4IsSet(true);
      }
      if (incoming.get(4)) {
        struct.axis5 = iprot.readDouble();
        struct.setAxis5IsSet(true);
      }
      if (incoming.get(5)) {
        struct.axis6 = iprot.readDouble();
        struct.setAxis6IsSet(true);
      }
      if (incoming.get(6)) {
        struct.axis7 = iprot.readDouble();
        struct.setAxis7IsSet(true);
      }
      if (incoming.get(7)) {
        struct.axis8 = iprot.readDouble();
        struct.setAxis8IsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

