package com.example.ex3_2_back.grpc.server.vision;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.56.1)",
    comments = "Source: vision.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class VisionServiceGrpc {

  private VisionServiceGrpc() {}

  public static final String SERVICE_NAME = "vision.VisionService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.ex3_2_back.grpc.server.vision.FaceCollectionRequest,
      com.example.ex3_2_back.grpc.server.vision.CommonResopnse> getFaceCollectionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FaceCollection",
      requestType = com.example.ex3_2_back.grpc.server.vision.FaceCollectionRequest.class,
      responseType = com.example.ex3_2_back.grpc.server.vision.CommonResopnse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.ex3_2_back.grpc.server.vision.FaceCollectionRequest,
      com.example.ex3_2_back.grpc.server.vision.CommonResopnse> getFaceCollectionMethod() {
    io.grpc.MethodDescriptor<com.example.ex3_2_back.grpc.server.vision.FaceCollectionRequest, com.example.ex3_2_back.grpc.server.vision.CommonResopnse> getFaceCollectionMethod;
    if ((getFaceCollectionMethod = VisionServiceGrpc.getFaceCollectionMethod) == null) {
      synchronized (VisionServiceGrpc.class) {
        if ((getFaceCollectionMethod = VisionServiceGrpc.getFaceCollectionMethod) == null) {
          VisionServiceGrpc.getFaceCollectionMethod = getFaceCollectionMethod =
              io.grpc.MethodDescriptor.<com.example.ex3_2_back.grpc.server.vision.FaceCollectionRequest, com.example.ex3_2_back.grpc.server.vision.CommonResopnse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "FaceCollection"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.ex3_2_back.grpc.server.vision.FaceCollectionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.ex3_2_back.grpc.server.vision.CommonResopnse.getDefaultInstance()))
              .setSchemaDescriptor(new VisionServiceMethodDescriptorSupplier("FaceCollection"))
              .build();
        }
      }
    }
    return getFaceCollectionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.ex3_2_back.grpc.server.vision.RemoveUrlRequest,
      com.example.ex3_2_back.grpc.server.vision.CommonResopnse> getRemoveUrlMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RemoveUrl",
      requestType = com.example.ex3_2_back.grpc.server.vision.RemoveUrlRequest.class,
      responseType = com.example.ex3_2_back.grpc.server.vision.CommonResopnse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.ex3_2_back.grpc.server.vision.RemoveUrlRequest,
      com.example.ex3_2_back.grpc.server.vision.CommonResopnse> getRemoveUrlMethod() {
    io.grpc.MethodDescriptor<com.example.ex3_2_back.grpc.server.vision.RemoveUrlRequest, com.example.ex3_2_back.grpc.server.vision.CommonResopnse> getRemoveUrlMethod;
    if ((getRemoveUrlMethod = VisionServiceGrpc.getRemoveUrlMethod) == null) {
      synchronized (VisionServiceGrpc.class) {
        if ((getRemoveUrlMethod = VisionServiceGrpc.getRemoveUrlMethod) == null) {
          VisionServiceGrpc.getRemoveUrlMethod = getRemoveUrlMethod =
              io.grpc.MethodDescriptor.<com.example.ex3_2_back.grpc.server.vision.RemoveUrlRequest, com.example.ex3_2_back.grpc.server.vision.CommonResopnse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RemoveUrl"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.ex3_2_back.grpc.server.vision.RemoveUrlRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.ex3_2_back.grpc.server.vision.CommonResopnse.getDefaultInstance()))
              .setSchemaDescriptor(new VisionServiceMethodDescriptorSupplier("RemoveUrl"))
              .build();
        }
      }
    }
    return getRemoveUrlMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.ex3_2_back.grpc.server.vision.StartVisonServiceRequest,
      com.example.ex3_2_back.grpc.server.vision.CommonResopnse> getStartVisonServiceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StartVisonService",
      requestType = com.example.ex3_2_back.grpc.server.vision.StartVisonServiceRequest.class,
      responseType = com.example.ex3_2_back.grpc.server.vision.CommonResopnse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.ex3_2_back.grpc.server.vision.StartVisonServiceRequest,
      com.example.ex3_2_back.grpc.server.vision.CommonResopnse> getStartVisonServiceMethod() {
    io.grpc.MethodDescriptor<com.example.ex3_2_back.grpc.server.vision.StartVisonServiceRequest, com.example.ex3_2_back.grpc.server.vision.CommonResopnse> getStartVisonServiceMethod;
    if ((getStartVisonServiceMethod = VisionServiceGrpc.getStartVisonServiceMethod) == null) {
      synchronized (VisionServiceGrpc.class) {
        if ((getStartVisonServiceMethod = VisionServiceGrpc.getStartVisonServiceMethod) == null) {
          VisionServiceGrpc.getStartVisonServiceMethod = getStartVisonServiceMethod =
              io.grpc.MethodDescriptor.<com.example.ex3_2_back.grpc.server.vision.StartVisonServiceRequest, com.example.ex3_2_back.grpc.server.vision.CommonResopnse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StartVisonService"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.ex3_2_back.grpc.server.vision.StartVisonServiceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.ex3_2_back.grpc.server.vision.CommonResopnse.getDefaultInstance()))
              .setSchemaDescriptor(new VisionServiceMethodDescriptorSupplier("StartVisonService"))
              .build();
        }
      }
    }
    return getStartVisonServiceMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static VisionServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<VisionServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<VisionServiceStub>() {
        @java.lang.Override
        public VisionServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new VisionServiceStub(channel, callOptions);
        }
      };
    return VisionServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static VisionServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<VisionServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<VisionServiceBlockingStub>() {
        @java.lang.Override
        public VisionServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new VisionServiceBlockingStub(channel, callOptions);
        }
      };
    return VisionServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static VisionServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<VisionServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<VisionServiceFutureStub>() {
        @java.lang.Override
        public VisionServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new VisionServiceFutureStub(channel, callOptions);
        }
      };
    return VisionServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void faceCollection(com.example.ex3_2_back.grpc.server.vision.FaceCollectionRequest request,
        io.grpc.stub.StreamObserver<com.example.ex3_2_back.grpc.server.vision.CommonResopnse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getFaceCollectionMethod(), responseObserver);
    }

    /**
     */
    default void removeUrl(com.example.ex3_2_back.grpc.server.vision.RemoveUrlRequest request,
        io.grpc.stub.StreamObserver<com.example.ex3_2_back.grpc.server.vision.CommonResopnse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRemoveUrlMethod(), responseObserver);
    }

    /**
     */
    default void startVisonService(com.example.ex3_2_back.grpc.server.vision.StartVisonServiceRequest request,
        io.grpc.stub.StreamObserver<com.example.ex3_2_back.grpc.server.vision.CommonResopnse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStartVisonServiceMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service VisionService.
   */
  public static abstract class VisionServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return VisionServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service VisionService.
   */
  public static final class VisionServiceStub
      extends io.grpc.stub.AbstractAsyncStub<VisionServiceStub> {
    private VisionServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VisionServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new VisionServiceStub(channel, callOptions);
    }

    /**
     */
    public void faceCollection(com.example.ex3_2_back.grpc.server.vision.FaceCollectionRequest request,
        io.grpc.stub.StreamObserver<com.example.ex3_2_back.grpc.server.vision.CommonResopnse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFaceCollectionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void removeUrl(com.example.ex3_2_back.grpc.server.vision.RemoveUrlRequest request,
        io.grpc.stub.StreamObserver<com.example.ex3_2_back.grpc.server.vision.CommonResopnse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRemoveUrlMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void startVisonService(com.example.ex3_2_back.grpc.server.vision.StartVisonServiceRequest request,
        io.grpc.stub.StreamObserver<com.example.ex3_2_back.grpc.server.vision.CommonResopnse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStartVisonServiceMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service VisionService.
   */
  public static final class VisionServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<VisionServiceBlockingStub> {
    private VisionServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VisionServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new VisionServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.example.ex3_2_back.grpc.server.vision.CommonResopnse faceCollection(com.example.ex3_2_back.grpc.server.vision.FaceCollectionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFaceCollectionMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.ex3_2_back.grpc.server.vision.CommonResopnse removeUrl(com.example.ex3_2_back.grpc.server.vision.RemoveUrlRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRemoveUrlMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.ex3_2_back.grpc.server.vision.CommonResopnse startVisonService(com.example.ex3_2_back.grpc.server.vision.StartVisonServiceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStartVisonServiceMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service VisionService.
   */
  public static final class VisionServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<VisionServiceFutureStub> {
    private VisionServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VisionServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new VisionServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.ex3_2_back.grpc.server.vision.CommonResopnse> faceCollection(
        com.example.ex3_2_back.grpc.server.vision.FaceCollectionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFaceCollectionMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.ex3_2_back.grpc.server.vision.CommonResopnse> removeUrl(
        com.example.ex3_2_back.grpc.server.vision.RemoveUrlRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRemoveUrlMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.ex3_2_back.grpc.server.vision.CommonResopnse> startVisonService(
        com.example.ex3_2_back.grpc.server.vision.StartVisonServiceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStartVisonServiceMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_FACE_COLLECTION = 0;
  private static final int METHODID_REMOVE_URL = 1;
  private static final int METHODID_START_VISON_SERVICE = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_FACE_COLLECTION:
          serviceImpl.faceCollection((com.example.ex3_2_back.grpc.server.vision.FaceCollectionRequest) request,
              (io.grpc.stub.StreamObserver<com.example.ex3_2_back.grpc.server.vision.CommonResopnse>) responseObserver);
          break;
        case METHODID_REMOVE_URL:
          serviceImpl.removeUrl((com.example.ex3_2_back.grpc.server.vision.RemoveUrlRequest) request,
              (io.grpc.stub.StreamObserver<com.example.ex3_2_back.grpc.server.vision.CommonResopnse>) responseObserver);
          break;
        case METHODID_START_VISON_SERVICE:
          serviceImpl.startVisonService((com.example.ex3_2_back.grpc.server.vision.StartVisonServiceRequest) request,
              (io.grpc.stub.StreamObserver<com.example.ex3_2_back.grpc.server.vision.CommonResopnse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getFaceCollectionMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.example.ex3_2_back.grpc.server.vision.FaceCollectionRequest,
              com.example.ex3_2_back.grpc.server.vision.CommonResopnse>(
                service, METHODID_FACE_COLLECTION)))
        .addMethod(
          getRemoveUrlMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.example.ex3_2_back.grpc.server.vision.RemoveUrlRequest,
              com.example.ex3_2_back.grpc.server.vision.CommonResopnse>(
                service, METHODID_REMOVE_URL)))
        .addMethod(
          getStartVisonServiceMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.example.ex3_2_back.grpc.server.vision.StartVisonServiceRequest,
              com.example.ex3_2_back.grpc.server.vision.CommonResopnse>(
                service, METHODID_START_VISON_SERVICE)))
        .build();
  }

  private static abstract class VisionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    VisionServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.ex3_2_back.grpc.server.vision.VisionProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("VisionService");
    }
  }

  private static final class VisionServiceFileDescriptorSupplier
      extends VisionServiceBaseDescriptorSupplier {
    VisionServiceFileDescriptorSupplier() {}
  }

  private static final class VisionServiceMethodDescriptorSupplier
      extends VisionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    VisionServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (VisionServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new VisionServiceFileDescriptorSupplier())
              .addMethod(getFaceCollectionMethod())
              .addMethod(getRemoveUrlMethod())
              .addMethod(getStartVisonServiceMethod())
              .build();
        }
      }
    }
    return result;
  }
}
