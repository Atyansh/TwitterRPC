/**
 * Autogenerated by Thrift Compiler (0.9.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package edu.ucsd.cse124;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Tweet implements org.apache.thrift.TBase<Tweet, Tweet._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("Tweet");

  private static final org.apache.thrift.protocol.TField TWEET_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("tweetId", org.apache.thrift.protocol.TType.I64, (short)1);
  private static final org.apache.thrift.protocol.TField HANDLE_FIELD_DESC = new org.apache.thrift.protocol.TField("handle", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField POSTED_FIELD_DESC = new org.apache.thrift.protocol.TField("posted", org.apache.thrift.protocol.TType.I64, (short)3);
  private static final org.apache.thrift.protocol.TField NUM_STARS_FIELD_DESC = new org.apache.thrift.protocol.TField("numStars", org.apache.thrift.protocol.TType.I32, (short)4);
  private static final org.apache.thrift.protocol.TField TWEET_STRING_FIELD_DESC = new org.apache.thrift.protocol.TField("tweetString", org.apache.thrift.protocol.TType.STRING, (short)5);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new TweetStandardSchemeFactory());
    schemes.put(TupleScheme.class, new TweetTupleSchemeFactory());
  }

  public long tweetId; // required
  public String handle; // required
  public long posted; // required
  public int numStars; // required
  public String tweetString; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    TWEET_ID((short)1, "tweetId"),
    HANDLE((short)2, "handle"),
    POSTED((short)3, "posted"),
    NUM_STARS((short)4, "numStars"),
    TWEET_STRING((short)5, "tweetString");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // TWEET_ID
          return TWEET_ID;
        case 2: // HANDLE
          return HANDLE;
        case 3: // POSTED
          return POSTED;
        case 4: // NUM_STARS
          return NUM_STARS;
        case 5: // TWEET_STRING
          return TWEET_STRING;
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
  private static final int __TWEETID_ISSET_ID = 0;
  private static final int __POSTED_ISSET_ID = 1;
  private static final int __NUMSTARS_ISSET_ID = 2;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.TWEET_ID, new org.apache.thrift.meta_data.FieldMetaData("tweetId", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.HANDLE, new org.apache.thrift.meta_data.FieldMetaData("handle", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.POSTED, new org.apache.thrift.meta_data.FieldMetaData("posted", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.NUM_STARS, new org.apache.thrift.meta_data.FieldMetaData("numStars", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.TWEET_STRING, new org.apache.thrift.meta_data.FieldMetaData("tweetString", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(Tweet.class, metaDataMap);
  }

  public Tweet() {
  }

  public Tweet(
    long tweetId,
    String handle,
    long posted,
    int numStars,
    String tweetString)
  {
    this();
    this.tweetId = tweetId;
    setTweetIdIsSet(true);
    this.handle = handle;
    this.posted = posted;
    setPostedIsSet(true);
    this.numStars = numStars;
    setNumStarsIsSet(true);
    this.tweetString = tweetString;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public Tweet(Tweet other) {
    __isset_bitfield = other.__isset_bitfield;
    this.tweetId = other.tweetId;
    if (other.isSetHandle()) {
      this.handle = other.handle;
    }
    this.posted = other.posted;
    this.numStars = other.numStars;
    if (other.isSetTweetString()) {
      this.tweetString = other.tweetString;
    }
  }

  public Tweet deepCopy() {
    return new Tweet(this);
  }

  @Override
  public void clear() {
    setTweetIdIsSet(false);
    this.tweetId = 0;
    this.handle = null;
    setPostedIsSet(false);
    this.posted = 0;
    setNumStarsIsSet(false);
    this.numStars = 0;
    this.tweetString = null;
  }

  public long getTweetId() {
    return this.tweetId;
  }

  public Tweet setTweetId(long tweetId) {
    this.tweetId = tweetId;
    setTweetIdIsSet(true);
    return this;
  }

  public void unsetTweetId() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __TWEETID_ISSET_ID);
  }

  /** Returns true if field tweetId is set (has been assigned a value) and false otherwise */
  public boolean isSetTweetId() {
    return EncodingUtils.testBit(__isset_bitfield, __TWEETID_ISSET_ID);
  }

  public void setTweetIdIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __TWEETID_ISSET_ID, value);
  }

  public String getHandle() {
    return this.handle;
  }

  public Tweet setHandle(String handle) {
    this.handle = handle;
    return this;
  }

  public void unsetHandle() {
    this.handle = null;
  }

  /** Returns true if field handle is set (has been assigned a value) and false otherwise */
  public boolean isSetHandle() {
    return this.handle != null;
  }

  public void setHandleIsSet(boolean value) {
    if (!value) {
      this.handle = null;
    }
  }

  public long getPosted() {
    return this.posted;
  }

  public Tweet setPosted(long posted) {
    this.posted = posted;
    setPostedIsSet(true);
    return this;
  }

  public void unsetPosted() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __POSTED_ISSET_ID);
  }

  /** Returns true if field posted is set (has been assigned a value) and false otherwise */
  public boolean isSetPosted() {
    return EncodingUtils.testBit(__isset_bitfield, __POSTED_ISSET_ID);
  }

  public void setPostedIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __POSTED_ISSET_ID, value);
  }

  public int getNumStars() {
    return this.numStars;
  }

  public Tweet setNumStars(int numStars) {
    this.numStars = numStars;
    setNumStarsIsSet(true);
    return this;
  }

  public void unsetNumStars() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __NUMSTARS_ISSET_ID);
  }

  /** Returns true if field numStars is set (has been assigned a value) and false otherwise */
  public boolean isSetNumStars() {
    return EncodingUtils.testBit(__isset_bitfield, __NUMSTARS_ISSET_ID);
  }

  public void setNumStarsIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __NUMSTARS_ISSET_ID, value);
  }

  public String getTweetString() {
    return this.tweetString;
  }

  public Tweet setTweetString(String tweetString) {
    this.tweetString = tweetString;
    return this;
  }

  public void unsetTweetString() {
    this.tweetString = null;
  }

  /** Returns true if field tweetString is set (has been assigned a value) and false otherwise */
  public boolean isSetTweetString() {
    return this.tweetString != null;
  }

  public void setTweetStringIsSet(boolean value) {
    if (!value) {
      this.tweetString = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case TWEET_ID:
      if (value == null) {
        unsetTweetId();
      } else {
        setTweetId((Long)value);
      }
      break;

    case HANDLE:
      if (value == null) {
        unsetHandle();
      } else {
        setHandle((String)value);
      }
      break;

    case POSTED:
      if (value == null) {
        unsetPosted();
      } else {
        setPosted((Long)value);
      }
      break;

    case NUM_STARS:
      if (value == null) {
        unsetNumStars();
      } else {
        setNumStars((Integer)value);
      }
      break;

    case TWEET_STRING:
      if (value == null) {
        unsetTweetString();
      } else {
        setTweetString((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case TWEET_ID:
      return Long.valueOf(getTweetId());

    case HANDLE:
      return getHandle();

    case POSTED:
      return Long.valueOf(getPosted());

    case NUM_STARS:
      return Integer.valueOf(getNumStars());

    case TWEET_STRING:
      return getTweetString();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case TWEET_ID:
      return isSetTweetId();
    case HANDLE:
      return isSetHandle();
    case POSTED:
      return isSetPosted();
    case NUM_STARS:
      return isSetNumStars();
    case TWEET_STRING:
      return isSetTweetString();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof Tweet)
      return this.equals((Tweet)that);
    return false;
  }

  public boolean equals(Tweet that) {
    if (that == null)
      return false;

    boolean this_present_tweetId = true;
    boolean that_present_tweetId = true;
    if (this_present_tweetId || that_present_tweetId) {
      if (!(this_present_tweetId && that_present_tweetId))
        return false;
      if (this.tweetId != that.tweetId)
        return false;
    }

    boolean this_present_handle = true && this.isSetHandle();
    boolean that_present_handle = true && that.isSetHandle();
    if (this_present_handle || that_present_handle) {
      if (!(this_present_handle && that_present_handle))
        return false;
      if (!this.handle.equals(that.handle))
        return false;
    }

    boolean this_present_posted = true;
    boolean that_present_posted = true;
    if (this_present_posted || that_present_posted) {
      if (!(this_present_posted && that_present_posted))
        return false;
      if (this.posted != that.posted)
        return false;
    }

    boolean this_present_numStars = true;
    boolean that_present_numStars = true;
    if (this_present_numStars || that_present_numStars) {
      if (!(this_present_numStars && that_present_numStars))
        return false;
      if (this.numStars != that.numStars)
        return false;
    }

    boolean this_present_tweetString = true && this.isSetTweetString();
    boolean that_present_tweetString = true && that.isSetTweetString();
    if (this_present_tweetString || that_present_tweetString) {
      if (!(this_present_tweetString && that_present_tweetString))
        return false;
      if (!this.tweetString.equals(that.tweetString))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  public int compareTo(Tweet other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    Tweet typedOther = (Tweet)other;

    lastComparison = Boolean.valueOf(isSetTweetId()).compareTo(typedOther.isSetTweetId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTweetId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.tweetId, typedOther.tweetId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetHandle()).compareTo(typedOther.isSetHandle());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetHandle()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.handle, typedOther.handle);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetPosted()).compareTo(typedOther.isSetPosted());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPosted()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.posted, typedOther.posted);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetNumStars()).compareTo(typedOther.isSetNumStars());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetNumStars()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.numStars, typedOther.numStars);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetTweetString()).compareTo(typedOther.isSetTweetString());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTweetString()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.tweetString, typedOther.tweetString);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("Tweet(");
    boolean first = true;

    sb.append("tweetId:");
    sb.append(this.tweetId);
    first = false;
    if (!first) sb.append(", ");
    sb.append("handle:");
    if (this.handle == null) {
      sb.append("null");
    } else {
      sb.append(this.handle);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("posted:");
    sb.append(this.posted);
    first = false;
    if (!first) sb.append(", ");
    sb.append("numStars:");
    sb.append(this.numStars);
    first = false;
    if (!first) sb.append(", ");
    sb.append("tweetString:");
    if (this.tweetString == null) {
      sb.append("null");
    } else {
      sb.append(this.tweetString);
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
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class TweetStandardSchemeFactory implements SchemeFactory {
    public TweetStandardScheme getScheme() {
      return new TweetStandardScheme();
    }
  }

  private static class TweetStandardScheme extends StandardScheme<Tweet> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, Tweet struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // TWEET_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.tweetId = iprot.readI64();
              struct.setTweetIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // HANDLE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.handle = iprot.readString();
              struct.setHandleIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // POSTED
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.posted = iprot.readI64();
              struct.setPostedIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // NUM_STARS
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.numStars = iprot.readI32();
              struct.setNumStarsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // TWEET_STRING
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.tweetString = iprot.readString();
              struct.setTweetStringIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, Tweet struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(TWEET_ID_FIELD_DESC);
      oprot.writeI64(struct.tweetId);
      oprot.writeFieldEnd();
      if (struct.handle != null) {
        oprot.writeFieldBegin(HANDLE_FIELD_DESC);
        oprot.writeString(struct.handle);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(POSTED_FIELD_DESC);
      oprot.writeI64(struct.posted);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(NUM_STARS_FIELD_DESC);
      oprot.writeI32(struct.numStars);
      oprot.writeFieldEnd();
      if (struct.tweetString != null) {
        oprot.writeFieldBegin(TWEET_STRING_FIELD_DESC);
        oprot.writeString(struct.tweetString);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TweetTupleSchemeFactory implements SchemeFactory {
    public TweetTupleScheme getScheme() {
      return new TweetTupleScheme();
    }
  }

  private static class TweetTupleScheme extends TupleScheme<Tweet> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, Tweet struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetTweetId()) {
        optionals.set(0);
      }
      if (struct.isSetHandle()) {
        optionals.set(1);
      }
      if (struct.isSetPosted()) {
        optionals.set(2);
      }
      if (struct.isSetNumStars()) {
        optionals.set(3);
      }
      if (struct.isSetTweetString()) {
        optionals.set(4);
      }
      oprot.writeBitSet(optionals, 5);
      if (struct.isSetTweetId()) {
        oprot.writeI64(struct.tweetId);
      }
      if (struct.isSetHandle()) {
        oprot.writeString(struct.handle);
      }
      if (struct.isSetPosted()) {
        oprot.writeI64(struct.posted);
      }
      if (struct.isSetNumStars()) {
        oprot.writeI32(struct.numStars);
      }
      if (struct.isSetTweetString()) {
        oprot.writeString(struct.tweetString);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, Tweet struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(5);
      if (incoming.get(0)) {
        struct.tweetId = iprot.readI64();
        struct.setTweetIdIsSet(true);
      }
      if (incoming.get(1)) {
        struct.handle = iprot.readString();
        struct.setHandleIsSet(true);
      }
      if (incoming.get(2)) {
        struct.posted = iprot.readI64();
        struct.setPostedIsSet(true);
      }
      if (incoming.get(3)) {
        struct.numStars = iprot.readI32();
        struct.setNumStarsIsSet(true);
      }
      if (incoming.get(4)) {
        struct.tweetString = iprot.readString();
        struct.setTweetStringIsSet(true);
      }
    }
  }

}
