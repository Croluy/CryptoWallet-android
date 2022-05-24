// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: axelar/reward/v1beta1/params.proto

package axelar.reward.v1beta1;

public final class ParamsOuterClass {
  private ParamsOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface ParamsOrBuilder extends
      // @@protoc_insertion_point(interface_extends:axelar.reward.v1beta1.Params)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>bytes external_chain_voting_inflation_rate = 1 [(.gogoproto.nullable) = false, (.gogoproto.customtype) = "github.com/cosmos/cosmos-sdk/types.Dec"];</code>
     * @return The externalChainVotingInflationRate.
     */
    com.google.protobuf.ByteString getExternalChainVotingInflationRate();

    /**
     * <code>bytes tss_relative_inflation_rate = 2 [(.gogoproto.nullable) = false, (.gogoproto.customtype) = "github.com/cosmos/cosmos-sdk/types.Dec"];</code>
     * @return The tssRelativeInflationRate.
     */
    com.google.protobuf.ByteString getTssRelativeInflationRate();
  }
  /**
   * <pre>
   * Params represent the genesis parameters for the module
   * </pre>
   *
   * Protobuf type {@code axelar.reward.v1beta1.Params}
   */
  public static final class Params extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:axelar.reward.v1beta1.Params)
      ParamsOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use Params.newBuilder() to construct.
    private Params(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private Params() {
      externalChainVotingInflationRate_ = com.google.protobuf.ByteString.EMPTY;
      tssRelativeInflationRate_ = com.google.protobuf.ByteString.EMPTY;
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
        UnusedPrivateParameter unused) {
      return new Params();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private Params(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 10: {

              externalChainVotingInflationRate_ = input.readBytes();
              break;
            }
            case 18: {

              tssRelativeInflationRate_ = input.readBytes();
              break;
            }
            default: {
              if (!parseUnknownField(
                  input, unknownFields, extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return axelar.reward.v1beta1.ParamsOuterClass.internal_static_axelar_reward_v1beta1_Params_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return axelar.reward.v1beta1.ParamsOuterClass.internal_static_axelar_reward_v1beta1_Params_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              axelar.reward.v1beta1.ParamsOuterClass.Params.class, axelar.reward.v1beta1.ParamsOuterClass.Params.Builder.class);
    }

    public static final int EXTERNAL_CHAIN_VOTING_INFLATION_RATE_FIELD_NUMBER = 1;
    private com.google.protobuf.ByteString externalChainVotingInflationRate_;
    /**
     * <code>bytes external_chain_voting_inflation_rate = 1 [(.gogoproto.nullable) = false, (.gogoproto.customtype) = "github.com/cosmos/cosmos-sdk/types.Dec"];</code>
     * @return The externalChainVotingInflationRate.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString getExternalChainVotingInflationRate() {
      return externalChainVotingInflationRate_;
    }

    public static final int TSS_RELATIVE_INFLATION_RATE_FIELD_NUMBER = 2;
    private com.google.protobuf.ByteString tssRelativeInflationRate_;
    /**
     * <code>bytes tss_relative_inflation_rate = 2 [(.gogoproto.nullable) = false, (.gogoproto.customtype) = "github.com/cosmos/cosmos-sdk/types.Dec"];</code>
     * @return The tssRelativeInflationRate.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString getTssRelativeInflationRate() {
      return tssRelativeInflationRate_;
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
      if (!externalChainVotingInflationRate_.isEmpty()) {
        output.writeBytes(1, externalChainVotingInflationRate_);
      }
      if (!tssRelativeInflationRate_.isEmpty()) {
        output.writeBytes(2, tssRelativeInflationRate_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (!externalChainVotingInflationRate_.isEmpty()) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(1, externalChainVotingInflationRate_);
      }
      if (!tssRelativeInflationRate_.isEmpty()) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(2, tssRelativeInflationRate_);
      }
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof axelar.reward.v1beta1.ParamsOuterClass.Params)) {
        return super.equals(obj);
      }
      axelar.reward.v1beta1.ParamsOuterClass.Params other = (axelar.reward.v1beta1.ParamsOuterClass.Params) obj;

      if (!getExternalChainVotingInflationRate()
          .equals(other.getExternalChainVotingInflationRate())) return false;
      if (!getTssRelativeInflationRate()
          .equals(other.getTssRelativeInflationRate())) return false;
      if (!unknownFields.equals(other.unknownFields)) return false;
      return true;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      hash = (37 * hash) + EXTERNAL_CHAIN_VOTING_INFLATION_RATE_FIELD_NUMBER;
      hash = (53 * hash) + getExternalChainVotingInflationRate().hashCode();
      hash = (37 * hash) + TSS_RELATIVE_INFLATION_RATE_FIELD_NUMBER;
      hash = (53 * hash) + getTssRelativeInflationRate().hashCode();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static axelar.reward.v1beta1.ParamsOuterClass.Params parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static axelar.reward.v1beta1.ParamsOuterClass.Params parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static axelar.reward.v1beta1.ParamsOuterClass.Params parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static axelar.reward.v1beta1.ParamsOuterClass.Params parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static axelar.reward.v1beta1.ParamsOuterClass.Params parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static axelar.reward.v1beta1.ParamsOuterClass.Params parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static axelar.reward.v1beta1.ParamsOuterClass.Params parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static axelar.reward.v1beta1.ParamsOuterClass.Params parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static axelar.reward.v1beta1.ParamsOuterClass.Params parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static axelar.reward.v1beta1.ParamsOuterClass.Params parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static axelar.reward.v1beta1.ParamsOuterClass.Params parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static axelar.reward.v1beta1.ParamsOuterClass.Params parseFrom(
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
    public static Builder newBuilder(axelar.reward.v1beta1.ParamsOuterClass.Params prototype) {
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
     * Params represent the genesis parameters for the module
     * </pre>
     *
     * Protobuf type {@code axelar.reward.v1beta1.Params}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:axelar.reward.v1beta1.Params)
        axelar.reward.v1beta1.ParamsOuterClass.ParamsOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return axelar.reward.v1beta1.ParamsOuterClass.internal_static_axelar_reward_v1beta1_Params_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return axelar.reward.v1beta1.ParamsOuterClass.internal_static_axelar_reward_v1beta1_Params_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                axelar.reward.v1beta1.ParamsOuterClass.Params.class, axelar.reward.v1beta1.ParamsOuterClass.Params.Builder.class);
      }

      // Construct using axelar.reward.v1beta1.ParamsOuterClass.Params.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      @java.lang.Override
      public Builder clear() {
        super.clear();
        externalChainVotingInflationRate_ = com.google.protobuf.ByteString.EMPTY;

        tssRelativeInflationRate_ = com.google.protobuf.ByteString.EMPTY;

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return axelar.reward.v1beta1.ParamsOuterClass.internal_static_axelar_reward_v1beta1_Params_descriptor;
      }

      @java.lang.Override
      public axelar.reward.v1beta1.ParamsOuterClass.Params getDefaultInstanceForType() {
        return axelar.reward.v1beta1.ParamsOuterClass.Params.getDefaultInstance();
      }

      @java.lang.Override
      public axelar.reward.v1beta1.ParamsOuterClass.Params build() {
        axelar.reward.v1beta1.ParamsOuterClass.Params result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public axelar.reward.v1beta1.ParamsOuterClass.Params buildPartial() {
        axelar.reward.v1beta1.ParamsOuterClass.Params result = new axelar.reward.v1beta1.ParamsOuterClass.Params(this);
        result.externalChainVotingInflationRate_ = externalChainVotingInflationRate_;
        result.tssRelativeInflationRate_ = tssRelativeInflationRate_;
        onBuilt();
        return result;
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
        if (other instanceof axelar.reward.v1beta1.ParamsOuterClass.Params) {
          return mergeFrom((axelar.reward.v1beta1.ParamsOuterClass.Params)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(axelar.reward.v1beta1.ParamsOuterClass.Params other) {
        if (other == axelar.reward.v1beta1.ParamsOuterClass.Params.getDefaultInstance()) return this;
        if (other.getExternalChainVotingInflationRate() != com.google.protobuf.ByteString.EMPTY) {
          setExternalChainVotingInflationRate(other.getExternalChainVotingInflationRate());
        }
        if (other.getTssRelativeInflationRate() != com.google.protobuf.ByteString.EMPTY) {
          setTssRelativeInflationRate(other.getTssRelativeInflationRate());
        }
        this.mergeUnknownFields(other.unknownFields);
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
        axelar.reward.v1beta1.ParamsOuterClass.Params parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (axelar.reward.v1beta1.ParamsOuterClass.Params) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private com.google.protobuf.ByteString externalChainVotingInflationRate_ = com.google.protobuf.ByteString.EMPTY;
      /**
       * <code>bytes external_chain_voting_inflation_rate = 1 [(.gogoproto.nullable) = false, (.gogoproto.customtype) = "github.com/cosmos/cosmos-sdk/types.Dec"];</code>
       * @return The externalChainVotingInflationRate.
       */
      @java.lang.Override
      public com.google.protobuf.ByteString getExternalChainVotingInflationRate() {
        return externalChainVotingInflationRate_;
      }
      /**
       * <code>bytes external_chain_voting_inflation_rate = 1 [(.gogoproto.nullable) = false, (.gogoproto.customtype) = "github.com/cosmos/cosmos-sdk/types.Dec"];</code>
       * @param value The externalChainVotingInflationRate to set.
       * @return This builder for chaining.
       */
      public Builder setExternalChainVotingInflationRate(com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        externalChainVotingInflationRate_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>bytes external_chain_voting_inflation_rate = 1 [(.gogoproto.nullable) = false, (.gogoproto.customtype) = "github.com/cosmos/cosmos-sdk/types.Dec"];</code>
       * @return This builder for chaining.
       */
      public Builder clearExternalChainVotingInflationRate() {
        
        externalChainVotingInflationRate_ = getDefaultInstance().getExternalChainVotingInflationRate();
        onChanged();
        return this;
      }

      private com.google.protobuf.ByteString tssRelativeInflationRate_ = com.google.protobuf.ByteString.EMPTY;
      /**
       * <code>bytes tss_relative_inflation_rate = 2 [(.gogoproto.nullable) = false, (.gogoproto.customtype) = "github.com/cosmos/cosmos-sdk/types.Dec"];</code>
       * @return The tssRelativeInflationRate.
       */
      @java.lang.Override
      public com.google.protobuf.ByteString getTssRelativeInflationRate() {
        return tssRelativeInflationRate_;
      }
      /**
       * <code>bytes tss_relative_inflation_rate = 2 [(.gogoproto.nullable) = false, (.gogoproto.customtype) = "github.com/cosmos/cosmos-sdk/types.Dec"];</code>
       * @param value The tssRelativeInflationRate to set.
       * @return This builder for chaining.
       */
      public Builder setTssRelativeInflationRate(com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        tssRelativeInflationRate_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>bytes tss_relative_inflation_rate = 2 [(.gogoproto.nullable) = false, (.gogoproto.customtype) = "github.com/cosmos/cosmos-sdk/types.Dec"];</code>
       * @return This builder for chaining.
       */
      public Builder clearTssRelativeInflationRate() {
        
        tssRelativeInflationRate_ = getDefaultInstance().getTssRelativeInflationRate();
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


      // @@protoc_insertion_point(builder_scope:axelar.reward.v1beta1.Params)
    }

    // @@protoc_insertion_point(class_scope:axelar.reward.v1beta1.Params)
    private static final axelar.reward.v1beta1.ParamsOuterClass.Params DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new axelar.reward.v1beta1.ParamsOuterClass.Params();
    }

    public static axelar.reward.v1beta1.ParamsOuterClass.Params getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<Params>
        PARSER = new com.google.protobuf.AbstractParser<Params>() {
      @java.lang.Override
      public Params parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new Params(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<Params> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<Params> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public axelar.reward.v1beta1.ParamsOuterClass.Params getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_axelar_reward_v1beta1_Params_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_axelar_reward_v1beta1_Params_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\"axelar/reward/v1beta1/params.proto\022\025ax" +
      "elar.reward.v1beta1\032\024gogoproto/gogo.prot" +
      "o\"\273\001\n\006Params\022\\\n$external_chain_voting_in" +
      "flation_rate\030\001 \001(\014B.\332\336\037&github.com/cosmo" +
      "s/cosmos-sdk/types.Dec\310\336\037\000\022S\n\033tss_relati" +
      "ve_inflation_rate\030\002 \001(\014B.\332\336\037&github.com/" +
      "cosmos/cosmos-sdk/types.Dec\310\336\037\000B9Z3githu" +
      "b.com/axelarnetwork/axelar-core/x/reward" +
      "/types\310\341\036\000b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.protobuf2.GoGoProtos.getDescriptor(),
        });
    internal_static_axelar_reward_v1beta1_Params_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_axelar_reward_v1beta1_Params_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_axelar_reward_v1beta1_Params_descriptor,
        new java.lang.String[] { "ExternalChainVotingInflationRate", "TssRelativeInflationRate", });
    com.google.protobuf.ExtensionRegistry registry =
        com.google.protobuf.ExtensionRegistry.newInstance();
    registry.add(com.google.protobuf2.GoGoProtos.customtype);
    registry.add(com.google.protobuf2.GoGoProtos.goprotoGettersAll);
    registry.add(com.google.protobuf2.GoGoProtos.nullable);
    com.google.protobuf.Descriptors.FileDescriptor
        .internalUpdateFileDescriptor(descriptor, registry);
    com.google.protobuf2.GoGoProtos.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}