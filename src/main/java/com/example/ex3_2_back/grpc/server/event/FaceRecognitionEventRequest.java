// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: event.proto

package com.example.ex3_2_back.grpc.server.event;

/**
 * <pre>
 *type 0-代表进门 1-代表出门
 * </pre>
 *
 * Protobuf type {@code event.FaceRecognitionEventRequest}
 */
public final class FaceRecognitionEventRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:event.FaceRecognitionEventRequest)
    FaceRecognitionEventRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use FaceRecognitionEventRequest.newBuilder() to construct.
  private FaceRecognitionEventRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private FaceRecognitionEventRequest() {
    identity_ = "";
    imageUrl_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new FaceRecognitionEventRequest();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.example.ex3_2_back.grpc.server.event.EventServiceProto.internal_static_event_FaceRecognitionEventRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.example.ex3_2_back.grpc.server.event.EventServiceProto.internal_static_event_FaceRecognitionEventRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.example.ex3_2_back.grpc.server.event.FaceRecognitionEventRequest.class, com.example.ex3_2_back.grpc.server.event.FaceRecognitionEventRequest.Builder.class);
  }

  public static final int USER_ID_FIELD_NUMBER = 1;
  private int userId_ = 0;
  /**
   * <code>int32 user_id = 1;</code>
   * @return The userId.
   */
  @java.lang.Override
  public int getUserId() {
    return userId_;
  }

  public static final int IDENTITY_FIELD_NUMBER = 2;
  @SuppressWarnings("serial")
  private volatile java.lang.Object identity_ = "";
  /**
   * <code>string identity = 2;</code>
   * @return The identity.
   */
  @java.lang.Override
  public java.lang.String getIdentity() {
    java.lang.Object ref = identity_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      identity_ = s;
      return s;
    }
  }
  /**
   * <code>string identity = 2;</code>
   * @return The bytes for identity.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getIdentityBytes() {
    java.lang.Object ref = identity_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      identity_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int IMAGEURL_FIELD_NUMBER = 3;
  @SuppressWarnings("serial")
  private volatile java.lang.Object imageUrl_ = "";
  /**
   * <code>string imageUrl = 3;</code>
   * @return The imageUrl.
   */
  @java.lang.Override
  public java.lang.String getImageUrl() {
    java.lang.Object ref = imageUrl_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      imageUrl_ = s;
      return s;
    }
  }
  /**
   * <code>string imageUrl = 3;</code>
   * @return The bytes for imageUrl.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getImageUrlBytes() {
    java.lang.Object ref = imageUrl_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      imageUrl_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int CAMERAID_FIELD_NUMBER = 4;
  private int cameraId_ = 0;
  /**
   * <code>int32 cameraId = 4;</code>
   * @return The cameraId.
   */
  @java.lang.Override
  public int getCameraId() {
    return cameraId_;
  }

  public static final int TYPE_FIELD_NUMBER = 5;
  private int type_ = 0;
  /**
   * <code>int32 type = 5;</code>
   * @return The type.
   */
  @java.lang.Override
  public int getType() {
    return type_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (userId_ != 0) {
      output.writeInt32(1, userId_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(identity_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, identity_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(imageUrl_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, imageUrl_);
    }
    if (cameraId_ != 0) {
      output.writeInt32(4, cameraId_);
    }
    if (type_ != 0) {
      output.writeInt32(5, type_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (userId_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, userId_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(identity_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, identity_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(imageUrl_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, imageUrl_);
    }
    if (cameraId_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(4, cameraId_);
    }
    if (type_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(5, type_);
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.example.ex3_2_back.grpc.server.event.FaceRecognitionEventRequest)) {
      return super.equals(obj);
    }
    com.example.ex3_2_back.grpc.server.event.FaceRecognitionEventRequest other = (com.example.ex3_2_back.grpc.server.event.FaceRecognitionEventRequest) obj;

    if (getUserId()
        != other.getUserId()) return false;
    if (!getIdentity()
        .equals(other.getIdentity())) return false;
    if (!getImageUrl()
        .equals(other.getImageUrl())) return false;
    if (getCameraId()
        != other.getCameraId()) return false;
    if (getType()
        != other.getType()) return false;
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + USER_ID_FIELD_NUMBER;
    hash = (53 * hash) + getUserId();
    hash = (37 * hash) + IDENTITY_FIELD_NUMBER;
    hash = (53 * hash) + getIdentity().hashCode();
    hash = (37 * hash) + IMAGEURL_FIELD_NUMBER;
    hash = (53 * hash) + getImageUrl().hashCode();
    hash = (37 * hash) + CAMERAID_FIELD_NUMBER;
    hash = (53 * hash) + getCameraId();
    hash = (37 * hash) + TYPE_FIELD_NUMBER;
    hash = (53 * hash) + getType();
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.example.ex3_2_back.grpc.server.event.FaceRecognitionEventRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.example.ex3_2_back.grpc.server.event.FaceRecognitionEventRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.example.ex3_2_back.grpc.server.event.FaceRecognitionEventRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.example.ex3_2_back.grpc.server.event.FaceRecognitionEventRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.example.ex3_2_back.grpc.server.event.FaceRecognitionEventRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.example.ex3_2_back.grpc.server.event.FaceRecognitionEventRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.example.ex3_2_back.grpc.server.event.FaceRecognitionEventRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.example.ex3_2_back.grpc.server.event.FaceRecognitionEventRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static com.example.ex3_2_back.grpc.server.event.FaceRecognitionEventRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static com.example.ex3_2_back.grpc.server.event.FaceRecognitionEventRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.example.ex3_2_back.grpc.server.event.FaceRecognitionEventRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.example.ex3_2_back.grpc.server.event.FaceRecognitionEventRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.example.ex3_2_back.grpc.server.event.FaceRecognitionEventRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * <pre>
   *type 0-代表进门 1-代表出门
   * </pre>
   *
   * Protobuf type {@code event.FaceRecognitionEventRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:event.FaceRecognitionEventRequest)
      com.example.ex3_2_back.grpc.server.event.FaceRecognitionEventRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.example.ex3_2_back.grpc.server.event.EventServiceProto.internal_static_event_FaceRecognitionEventRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.example.ex3_2_back.grpc.server.event.EventServiceProto.internal_static_event_FaceRecognitionEventRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.example.ex3_2_back.grpc.server.event.FaceRecognitionEventRequest.class, com.example.ex3_2_back.grpc.server.event.FaceRecognitionEventRequest.Builder.class);
    }

    // Construct using com.example.ex3_2_back.grpc.server.event.FaceRecognitionEventRequest.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      userId_ = 0;
      identity_ = "";
      imageUrl_ = "";
      cameraId_ = 0;
      type_ = 0;
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.example.ex3_2_back.grpc.server.event.EventServiceProto.internal_static_event_FaceRecognitionEventRequest_descriptor;
    }

    @java.lang.Override
    public com.example.ex3_2_back.grpc.server.event.FaceRecognitionEventRequest getDefaultInstanceForType() {
      return com.example.ex3_2_back.grpc.server.event.FaceRecognitionEventRequest.getDefaultInstance();
    }

    @java.lang.Override
    public com.example.ex3_2_back.grpc.server.event.FaceRecognitionEventRequest build() {
      com.example.ex3_2_back.grpc.server.event.FaceRecognitionEventRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.example.ex3_2_back.grpc.server.event.FaceRecognitionEventRequest buildPartial() {
      com.example.ex3_2_back.grpc.server.event.FaceRecognitionEventRequest result = new com.example.ex3_2_back.grpc.server.event.FaceRecognitionEventRequest(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(com.example.ex3_2_back.grpc.server.event.FaceRecognitionEventRequest result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.userId_ = userId_;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.identity_ = identity_;
      }
      if (((from_bitField0_ & 0x00000004) != 0)) {
        result.imageUrl_ = imageUrl_;
      }
      if (((from_bitField0_ & 0x00000008) != 0)) {
        result.cameraId_ = cameraId_;
      }
      if (((from_bitField0_ & 0x00000010) != 0)) {
        result.type_ = type_;
      }
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.example.ex3_2_back.grpc.server.event.FaceRecognitionEventRequest) {
        return mergeFrom((com.example.ex3_2_back.grpc.server.event.FaceRecognitionEventRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.example.ex3_2_back.grpc.server.event.FaceRecognitionEventRequest other) {
      if (other == com.example.ex3_2_back.grpc.server.event.FaceRecognitionEventRequest.getDefaultInstance()) return this;
      if (other.getUserId() != 0) {
        setUserId(other.getUserId());
      }
      if (!other.getIdentity().isEmpty()) {
        identity_ = other.identity_;
        bitField0_ |= 0x00000002;
        onChanged();
      }
      if (!other.getImageUrl().isEmpty()) {
        imageUrl_ = other.imageUrl_;
        bitField0_ |= 0x00000004;
        onChanged();
      }
      if (other.getCameraId() != 0) {
        setCameraId(other.getCameraId());
      }
      if (other.getType() != 0) {
        setType(other.getType());
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 8: {
              userId_ = input.readInt32();
              bitField0_ |= 0x00000001;
              break;
            } // case 8
            case 18: {
              identity_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000002;
              break;
            } // case 18
            case 26: {
              imageUrl_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000004;
              break;
            } // case 26
            case 32: {
              cameraId_ = input.readInt32();
              bitField0_ |= 0x00000008;
              break;
            } // case 32
            case 40: {
              type_ = input.readInt32();
              bitField0_ |= 0x00000010;
              break;
            } // case 40
            default: {
              if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                done = true; // was an endgroup tag
              }
              break;
            } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }
    private int bitField0_;

    private int userId_ ;
    /**
     * <code>int32 user_id = 1;</code>
     * @return The userId.
     */
    @java.lang.Override
    public int getUserId() {
      return userId_;
    }
    /**
     * <code>int32 user_id = 1;</code>
     * @param value The userId to set.
     * @return This builder for chaining.
     */
    public Builder setUserId(int value) {

      userId_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>int32 user_id = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearUserId() {
      bitField0_ = (bitField0_ & ~0x00000001);
      userId_ = 0;
      onChanged();
      return this;
    }

    private java.lang.Object identity_ = "";
    /**
     * <code>string identity = 2;</code>
     * @return The identity.
     */
    public java.lang.String getIdentity() {
      java.lang.Object ref = identity_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        identity_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string identity = 2;</code>
     * @return The bytes for identity.
     */
    public com.google.protobuf.ByteString
        getIdentityBytes() {
      java.lang.Object ref = identity_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        identity_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string identity = 2;</code>
     * @param value The identity to set.
     * @return This builder for chaining.
     */
    public Builder setIdentity(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      identity_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>string identity = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearIdentity() {
      identity_ = getDefaultInstance().getIdentity();
      bitField0_ = (bitField0_ & ~0x00000002);
      onChanged();
      return this;
    }
    /**
     * <code>string identity = 2;</code>
     * @param value The bytes for identity to set.
     * @return This builder for chaining.
     */
    public Builder setIdentityBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      identity_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }

    private java.lang.Object imageUrl_ = "";
    /**
     * <code>string imageUrl = 3;</code>
     * @return The imageUrl.
     */
    public java.lang.String getImageUrl() {
      java.lang.Object ref = imageUrl_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        imageUrl_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string imageUrl = 3;</code>
     * @return The bytes for imageUrl.
     */
    public com.google.protobuf.ByteString
        getImageUrlBytes() {
      java.lang.Object ref = imageUrl_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        imageUrl_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string imageUrl = 3;</code>
     * @param value The imageUrl to set.
     * @return This builder for chaining.
     */
    public Builder setImageUrl(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      imageUrl_ = value;
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }
    /**
     * <code>string imageUrl = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearImageUrl() {
      imageUrl_ = getDefaultInstance().getImageUrl();
      bitField0_ = (bitField0_ & ~0x00000004);
      onChanged();
      return this;
    }
    /**
     * <code>string imageUrl = 3;</code>
     * @param value The bytes for imageUrl to set.
     * @return This builder for chaining.
     */
    public Builder setImageUrlBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      imageUrl_ = value;
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }

    private int cameraId_ ;
    /**
     * <code>int32 cameraId = 4;</code>
     * @return The cameraId.
     */
    @java.lang.Override
    public int getCameraId() {
      return cameraId_;
    }
    /**
     * <code>int32 cameraId = 4;</code>
     * @param value The cameraId to set.
     * @return This builder for chaining.
     */
    public Builder setCameraId(int value) {

      cameraId_ = value;
      bitField0_ |= 0x00000008;
      onChanged();
      return this;
    }
    /**
     * <code>int32 cameraId = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearCameraId() {
      bitField0_ = (bitField0_ & ~0x00000008);
      cameraId_ = 0;
      onChanged();
      return this;
    }

    private int type_ ;
    /**
     * <code>int32 type = 5;</code>
     * @return The type.
     */
    @java.lang.Override
    public int getType() {
      return type_;
    }
    /**
     * <code>int32 type = 5;</code>
     * @param value The type to set.
     * @return This builder for chaining.
     */
    public Builder setType(int value) {

      type_ = value;
      bitField0_ |= 0x00000010;
      onChanged();
      return this;
    }
    /**
     * <code>int32 type = 5;</code>
     * @return This builder for chaining.
     */
    public Builder clearType() {
      bitField0_ = (bitField0_ & ~0x00000010);
      type_ = 0;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:event.FaceRecognitionEventRequest)
  }

  // @@protoc_insertion_point(class_scope:event.FaceRecognitionEventRequest)
  private static final com.example.ex3_2_back.grpc.server.event.FaceRecognitionEventRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.example.ex3_2_back.grpc.server.event.FaceRecognitionEventRequest();
  }

  public static com.example.ex3_2_back.grpc.server.event.FaceRecognitionEventRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<FaceRecognitionEventRequest>
      PARSER = new com.google.protobuf.AbstractParser<FaceRecognitionEventRequest>() {
    @java.lang.Override
    public FaceRecognitionEventRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      Builder builder = newBuilder();
      try {
        builder.mergeFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(builder.buildPartial());
      } catch (com.google.protobuf.UninitializedMessageException e) {
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(e)
            .setUnfinishedMessage(builder.buildPartial());
      }
      return builder.buildPartial();
    }
  };

  public static com.google.protobuf.Parser<FaceRecognitionEventRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<FaceRecognitionEventRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.example.ex3_2_back.grpc.server.event.FaceRecognitionEventRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

