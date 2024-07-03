// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: event.proto

package com.example.ex3_2_back.grpc.server.event;

/**
 * Protobuf type {@code event.EmotionDetectionEventRequest}
 */
public final class EmotionDetectionEventRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:event.EmotionDetectionEventRequest)
    EmotionDetectionEventRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use EmotionDetectionEventRequest.newBuilder() to construct.
  private EmotionDetectionEventRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private EmotionDetectionEventRequest() {
    imageUrl_ = "";
    emotion_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new EmotionDetectionEventRequest();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.example.ex3_2_back.grpc.server.event.EventServiceProto.internal_static_event_EmotionDetectionEventRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.example.ex3_2_back.grpc.server.event.EventServiceProto.internal_static_event_EmotionDetectionEventRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.example.ex3_2_back.grpc.server.event.EmotionDetectionEventRequest.class, com.example.ex3_2_back.grpc.server.event.EmotionDetectionEventRequest.Builder.class);
  }

  public static final int ELDERLYID_FIELD_NUMBER = 1;
  private int elderlyId_ = 0;
  /**
   * <code>int32 elderlyId = 1;</code>
   * @return The elderlyId.
   */
  @java.lang.Override
  public int getElderlyId() {
    return elderlyId_;
  }

  public static final int IMAGEURL_FIELD_NUMBER = 2;
  @SuppressWarnings("serial")
  private volatile java.lang.Object imageUrl_ = "";
  /**
   * <code>string imageUrl = 2;</code>
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
   * <code>string imageUrl = 2;</code>
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

  public static final int EMOTION_FIELD_NUMBER = 3;
  @SuppressWarnings("serial")
  private volatile java.lang.Object emotion_ = "";
  /**
   * <code>string emotion = 3;</code>
   * @return The emotion.
   */
  @java.lang.Override
  public java.lang.String getEmotion() {
    java.lang.Object ref = emotion_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      emotion_ = s;
      return s;
    }
  }
  /**
   * <code>string emotion = 3;</code>
   * @return The bytes for emotion.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getEmotionBytes() {
    java.lang.Object ref = emotion_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      emotion_ = b;
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
    if (elderlyId_ != 0) {
      output.writeInt32(1, elderlyId_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(imageUrl_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, imageUrl_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(emotion_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, emotion_);
    }
    if (cameraId_ != 0) {
      output.writeInt32(4, cameraId_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (elderlyId_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, elderlyId_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(imageUrl_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, imageUrl_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(emotion_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, emotion_);
    }
    if (cameraId_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(4, cameraId_);
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
    if (!(obj instanceof com.example.ex3_2_back.grpc.server.event.EmotionDetectionEventRequest)) {
      return super.equals(obj);
    }
    com.example.ex3_2_back.grpc.server.event.EmotionDetectionEventRequest other = (com.example.ex3_2_back.grpc.server.event.EmotionDetectionEventRequest) obj;

    if (getElderlyId()
        != other.getElderlyId()) return false;
    if (!getImageUrl()
        .equals(other.getImageUrl())) return false;
    if (!getEmotion()
        .equals(other.getEmotion())) return false;
    if (getCameraId()
        != other.getCameraId()) return false;
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
    hash = (37 * hash) + ELDERLYID_FIELD_NUMBER;
    hash = (53 * hash) + getElderlyId();
    hash = (37 * hash) + IMAGEURL_FIELD_NUMBER;
    hash = (53 * hash) + getImageUrl().hashCode();
    hash = (37 * hash) + EMOTION_FIELD_NUMBER;
    hash = (53 * hash) + getEmotion().hashCode();
    hash = (37 * hash) + CAMERAID_FIELD_NUMBER;
    hash = (53 * hash) + getCameraId();
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.example.ex3_2_back.grpc.server.event.EmotionDetectionEventRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.example.ex3_2_back.grpc.server.event.EmotionDetectionEventRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.example.ex3_2_back.grpc.server.event.EmotionDetectionEventRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.example.ex3_2_back.grpc.server.event.EmotionDetectionEventRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.example.ex3_2_back.grpc.server.event.EmotionDetectionEventRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.example.ex3_2_back.grpc.server.event.EmotionDetectionEventRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.example.ex3_2_back.grpc.server.event.EmotionDetectionEventRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.example.ex3_2_back.grpc.server.event.EmotionDetectionEventRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static com.example.ex3_2_back.grpc.server.event.EmotionDetectionEventRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static com.example.ex3_2_back.grpc.server.event.EmotionDetectionEventRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.example.ex3_2_back.grpc.server.event.EmotionDetectionEventRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.example.ex3_2_back.grpc.server.event.EmotionDetectionEventRequest parseFrom(
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
  public static Builder newBuilder(com.example.ex3_2_back.grpc.server.event.EmotionDetectionEventRequest prototype) {
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
   * Protobuf type {@code event.EmotionDetectionEventRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:event.EmotionDetectionEventRequest)
      com.example.ex3_2_back.grpc.server.event.EmotionDetectionEventRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.example.ex3_2_back.grpc.server.event.EventServiceProto.internal_static_event_EmotionDetectionEventRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.example.ex3_2_back.grpc.server.event.EventServiceProto.internal_static_event_EmotionDetectionEventRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.example.ex3_2_back.grpc.server.event.EmotionDetectionEventRequest.class, com.example.ex3_2_back.grpc.server.event.EmotionDetectionEventRequest.Builder.class);
    }

    // Construct using com.example.ex3_2_back.grpc.server.event.EmotionDetectionEventRequest.newBuilder()
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
      elderlyId_ = 0;
      imageUrl_ = "";
      emotion_ = "";
      cameraId_ = 0;
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.example.ex3_2_back.grpc.server.event.EventServiceProto.internal_static_event_EmotionDetectionEventRequest_descriptor;
    }

    @java.lang.Override
    public com.example.ex3_2_back.grpc.server.event.EmotionDetectionEventRequest getDefaultInstanceForType() {
      return com.example.ex3_2_back.grpc.server.event.EmotionDetectionEventRequest.getDefaultInstance();
    }

    @java.lang.Override
    public com.example.ex3_2_back.grpc.server.event.EmotionDetectionEventRequest build() {
      com.example.ex3_2_back.grpc.server.event.EmotionDetectionEventRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.example.ex3_2_back.grpc.server.event.EmotionDetectionEventRequest buildPartial() {
      com.example.ex3_2_back.grpc.server.event.EmotionDetectionEventRequest result = new com.example.ex3_2_back.grpc.server.event.EmotionDetectionEventRequest(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(com.example.ex3_2_back.grpc.server.event.EmotionDetectionEventRequest result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.elderlyId_ = elderlyId_;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.imageUrl_ = imageUrl_;
      }
      if (((from_bitField0_ & 0x00000004) != 0)) {
        result.emotion_ = emotion_;
      }
      if (((from_bitField0_ & 0x00000008) != 0)) {
        result.cameraId_ = cameraId_;
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
      if (other instanceof com.example.ex3_2_back.grpc.server.event.EmotionDetectionEventRequest) {
        return mergeFrom((com.example.ex3_2_back.grpc.server.event.EmotionDetectionEventRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.example.ex3_2_back.grpc.server.event.EmotionDetectionEventRequest other) {
      if (other == com.example.ex3_2_back.grpc.server.event.EmotionDetectionEventRequest.getDefaultInstance()) return this;
      if (other.getElderlyId() != 0) {
        setElderlyId(other.getElderlyId());
      }
      if (!other.getImageUrl().isEmpty()) {
        imageUrl_ = other.imageUrl_;
        bitField0_ |= 0x00000002;
        onChanged();
      }
      if (!other.getEmotion().isEmpty()) {
        emotion_ = other.emotion_;
        bitField0_ |= 0x00000004;
        onChanged();
      }
      if (other.getCameraId() != 0) {
        setCameraId(other.getCameraId());
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
              elderlyId_ = input.readInt32();
              bitField0_ |= 0x00000001;
              break;
            } // case 8
            case 18: {
              imageUrl_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000002;
              break;
            } // case 18
            case 26: {
              emotion_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000004;
              break;
            } // case 26
            case 32: {
              cameraId_ = input.readInt32();
              bitField0_ |= 0x00000008;
              break;
            } // case 32
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

    private int elderlyId_ ;
    /**
     * <code>int32 elderlyId = 1;</code>
     * @return The elderlyId.
     */
    @java.lang.Override
    public int getElderlyId() {
      return elderlyId_;
    }
    /**
     * <code>int32 elderlyId = 1;</code>
     * @param value The elderlyId to set.
     * @return This builder for chaining.
     */
    public Builder setElderlyId(int value) {

      elderlyId_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>int32 elderlyId = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearElderlyId() {
      bitField0_ = (bitField0_ & ~0x00000001);
      elderlyId_ = 0;
      onChanged();
      return this;
    }

    private java.lang.Object imageUrl_ = "";
    /**
     * <code>string imageUrl = 2;</code>
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
     * <code>string imageUrl = 2;</code>
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
     * <code>string imageUrl = 2;</code>
     * @param value The imageUrl to set.
     * @return This builder for chaining.
     */
    public Builder setImageUrl(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      imageUrl_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>string imageUrl = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearImageUrl() {
      imageUrl_ = getDefaultInstance().getImageUrl();
      bitField0_ = (bitField0_ & ~0x00000002);
      onChanged();
      return this;
    }
    /**
     * <code>string imageUrl = 2;</code>
     * @param value The bytes for imageUrl to set.
     * @return This builder for chaining.
     */
    public Builder setImageUrlBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      imageUrl_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }

    private java.lang.Object emotion_ = "";
    /**
     * <code>string emotion = 3;</code>
     * @return The emotion.
     */
    public java.lang.String getEmotion() {
      java.lang.Object ref = emotion_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        emotion_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string emotion = 3;</code>
     * @return The bytes for emotion.
     */
    public com.google.protobuf.ByteString
        getEmotionBytes() {
      java.lang.Object ref = emotion_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        emotion_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string emotion = 3;</code>
     * @param value The emotion to set.
     * @return This builder for chaining.
     */
    public Builder setEmotion(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      emotion_ = value;
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }
    /**
     * <code>string emotion = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearEmotion() {
      emotion_ = getDefaultInstance().getEmotion();
      bitField0_ = (bitField0_ & ~0x00000004);
      onChanged();
      return this;
    }
    /**
     * <code>string emotion = 3;</code>
     * @param value The bytes for emotion to set.
     * @return This builder for chaining.
     */
    public Builder setEmotionBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      emotion_ = value;
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


    // @@protoc_insertion_point(builder_scope:event.EmotionDetectionEventRequest)
  }

  // @@protoc_insertion_point(class_scope:event.EmotionDetectionEventRequest)
  private static final com.example.ex3_2_back.grpc.server.event.EmotionDetectionEventRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.example.ex3_2_back.grpc.server.event.EmotionDetectionEventRequest();
  }

  public static com.example.ex3_2_back.grpc.server.event.EmotionDetectionEventRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<EmotionDetectionEventRequest>
      PARSER = new com.google.protobuf.AbstractParser<EmotionDetectionEventRequest>() {
    @java.lang.Override
    public EmotionDetectionEventRequest parsePartialFrom(
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

  public static com.google.protobuf.Parser<EmotionDetectionEventRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<EmotionDetectionEventRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.example.ex3_2_back.grpc.server.event.EmotionDetectionEventRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

