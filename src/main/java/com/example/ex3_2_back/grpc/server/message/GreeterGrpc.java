package com.example.ex3_2_back.grpc.server.message;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.56.1)",
    comments = "Source: message.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class GreeterGrpc {

  private GreeterGrpc() {}

  public static final String SERVICE_NAME = "message.Greeter";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.ex3_2_back.grpc.server.message.Model1RequestMessage,
      com.example.ex3_2_back.grpc.server.message.Model1ResponseMessage> getModel1RequestMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Model1Request",
      requestType = com.example.ex3_2_back.grpc.server.message.Model1RequestMessage.class,
      responseType = com.example.ex3_2_back.grpc.server.message.Model1ResponseMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.ex3_2_back.grpc.server.message.Model1RequestMessage,
      com.example.ex3_2_back.grpc.server.message.Model1ResponseMessage> getModel1RequestMethod() {
    io.grpc.MethodDescriptor<com.example.ex3_2_back.grpc.server.message.Model1RequestMessage, com.example.ex3_2_back.grpc.server.message.Model1ResponseMessage> getModel1RequestMethod;
    if ((getModel1RequestMethod = GreeterGrpc.getModel1RequestMethod) == null) {
      synchronized (GreeterGrpc.class) {
        if ((getModel1RequestMethod = GreeterGrpc.getModel1RequestMethod) == null) {
          GreeterGrpc.getModel1RequestMethod = getModel1RequestMethod =
              io.grpc.MethodDescriptor.<com.example.ex3_2_back.grpc.server.message.Model1RequestMessage, com.example.ex3_2_back.grpc.server.message.Model1ResponseMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Model1Request"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.ex3_2_back.grpc.server.message.Model1RequestMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.ex3_2_back.grpc.server.message.Model1ResponseMessage.getDefaultInstance()))
              .setSchemaDescriptor(new GreeterMethodDescriptorSupplier("Model1Request"))
              .build();
        }
      }
    }
    return getModel1RequestMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.ex3_2_back.grpc.server.message.Model2RequestMessage,
      com.example.ex3_2_back.grpc.server.message.Model2ResponseMessage> getModel2RequestMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Model2Request",
      requestType = com.example.ex3_2_back.grpc.server.message.Model2RequestMessage.class,
      responseType = com.example.ex3_2_back.grpc.server.message.Model2ResponseMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.ex3_2_back.grpc.server.message.Model2RequestMessage,
      com.example.ex3_2_back.grpc.server.message.Model2ResponseMessage> getModel2RequestMethod() {
    io.grpc.MethodDescriptor<com.example.ex3_2_back.grpc.server.message.Model2RequestMessage, com.example.ex3_2_back.grpc.server.message.Model2ResponseMessage> getModel2RequestMethod;
    if ((getModel2RequestMethod = GreeterGrpc.getModel2RequestMethod) == null) {
      synchronized (GreeterGrpc.class) {
        if ((getModel2RequestMethod = GreeterGrpc.getModel2RequestMethod) == null) {
          GreeterGrpc.getModel2RequestMethod = getModel2RequestMethod =
              io.grpc.MethodDescriptor.<com.example.ex3_2_back.grpc.server.message.Model2RequestMessage, com.example.ex3_2_back.grpc.server.message.Model2ResponseMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Model2Request"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.ex3_2_back.grpc.server.message.Model2RequestMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.ex3_2_back.grpc.server.message.Model2ResponseMessage.getDefaultInstance()))
              .setSchemaDescriptor(new GreeterMethodDescriptorSupplier("Model2Request"))
              .build();
        }
      }
    }
    return getModel2RequestMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.ex3_2_back.grpc.server.message.Model3RequestMessage,
      com.example.ex3_2_back.grpc.server.message.Model3ResponseMessage> getModel3RequestMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Model3Request",
      requestType = com.example.ex3_2_back.grpc.server.message.Model3RequestMessage.class,
      responseType = com.example.ex3_2_back.grpc.server.message.Model3ResponseMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.ex3_2_back.grpc.server.message.Model3RequestMessage,
      com.example.ex3_2_back.grpc.server.message.Model3ResponseMessage> getModel3RequestMethod() {
    io.grpc.MethodDescriptor<com.example.ex3_2_back.grpc.server.message.Model3RequestMessage, com.example.ex3_2_back.grpc.server.message.Model3ResponseMessage> getModel3RequestMethod;
    if ((getModel3RequestMethod = GreeterGrpc.getModel3RequestMethod) == null) {
      synchronized (GreeterGrpc.class) {
        if ((getModel3RequestMethod = GreeterGrpc.getModel3RequestMethod) == null) {
          GreeterGrpc.getModel3RequestMethod = getModel3RequestMethod =
              io.grpc.MethodDescriptor.<com.example.ex3_2_back.grpc.server.message.Model3RequestMessage, com.example.ex3_2_back.grpc.server.message.Model3ResponseMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Model3Request"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.ex3_2_back.grpc.server.message.Model3RequestMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.ex3_2_back.grpc.server.message.Model3ResponseMessage.getDefaultInstance()))
              .setSchemaDescriptor(new GreeterMethodDescriptorSupplier("Model3Request"))
              .build();
        }
      }
    }
    return getModel3RequestMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static GreeterStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GreeterStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GreeterStub>() {
        @java.lang.Override
        public GreeterStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GreeterStub(channel, callOptions);
        }
      };
    return GreeterStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GreeterBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GreeterBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GreeterBlockingStub>() {
        @java.lang.Override
        public GreeterBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GreeterBlockingStub(channel, callOptions);
        }
      };
    return GreeterBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static GreeterFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GreeterFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GreeterFutureStub>() {
        @java.lang.Override
        public GreeterFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GreeterFutureStub(channel, callOptions);
        }
      };
    return GreeterFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void model1Request(com.example.ex3_2_back.grpc.server.message.Model1RequestMessage request,
        io.grpc.stub.StreamObserver<com.example.ex3_2_back.grpc.server.message.Model1ResponseMessage> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getModel1RequestMethod(), responseObserver);
    }

    /**
     */
    default void model2Request(com.example.ex3_2_back.grpc.server.message.Model2RequestMessage request,
        io.grpc.stub.StreamObserver<com.example.ex3_2_back.grpc.server.message.Model2ResponseMessage> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getModel2RequestMethod(), responseObserver);
    }

    /**
     */
    default void model3Request(com.example.ex3_2_back.grpc.server.message.Model3RequestMessage request,
        io.grpc.stub.StreamObserver<com.example.ex3_2_back.grpc.server.message.Model3ResponseMessage> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getModel3RequestMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Greeter.
   */
  public static abstract class GreeterImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return GreeterGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Greeter.
   */
  public static final class GreeterStub
      extends io.grpc.stub.AbstractAsyncStub<GreeterStub> {
    private GreeterStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GreeterStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GreeterStub(channel, callOptions);
    }

    /**
     */
    public void model1Request(com.example.ex3_2_back.grpc.server.message.Model1RequestMessage request,
        io.grpc.stub.StreamObserver<com.example.ex3_2_back.grpc.server.message.Model1ResponseMessage> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getModel1RequestMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void model2Request(com.example.ex3_2_back.grpc.server.message.Model2RequestMessage request,
        io.grpc.stub.StreamObserver<com.example.ex3_2_back.grpc.server.message.Model2ResponseMessage> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getModel2RequestMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void model3Request(com.example.ex3_2_back.grpc.server.message.Model3RequestMessage request,
        io.grpc.stub.StreamObserver<com.example.ex3_2_back.grpc.server.message.Model3ResponseMessage> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getModel3RequestMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Greeter.
   */
  public static final class GreeterBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<GreeterBlockingStub> {
    private GreeterBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GreeterBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GreeterBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.example.ex3_2_back.grpc.server.message.Model1ResponseMessage model1Request(com.example.ex3_2_back.grpc.server.message.Model1RequestMessage request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getModel1RequestMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.ex3_2_back.grpc.server.message.Model2ResponseMessage model2Request(com.example.ex3_2_back.grpc.server.message.Model2RequestMessage request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getModel2RequestMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.ex3_2_back.grpc.server.message.Model3ResponseMessage model3Request(com.example.ex3_2_back.grpc.server.message.Model3RequestMessage request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getModel3RequestMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Greeter.
   */
  public static final class GreeterFutureStub
      extends io.grpc.stub.AbstractFutureStub<GreeterFutureStub> {
    private GreeterFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GreeterFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GreeterFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.ex3_2_back.grpc.server.message.Model1ResponseMessage> model1Request(
        com.example.ex3_2_back.grpc.server.message.Model1RequestMessage request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getModel1RequestMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.ex3_2_back.grpc.server.message.Model2ResponseMessage> model2Request(
        com.example.ex3_2_back.grpc.server.message.Model2RequestMessage request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getModel2RequestMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.ex3_2_back.grpc.server.message.Model3ResponseMessage> model3Request(
        com.example.ex3_2_back.grpc.server.message.Model3RequestMessage request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getModel3RequestMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_MODEL1REQUEST = 0;
  private static final int METHODID_MODEL2REQUEST = 1;
  private static final int METHODID_MODEL3REQUEST = 2;

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
        case METHODID_MODEL1REQUEST:
          serviceImpl.model1Request((com.example.ex3_2_back.grpc.server.message.Model1RequestMessage) request,
              (io.grpc.stub.StreamObserver<com.example.ex3_2_back.grpc.server.message.Model1ResponseMessage>) responseObserver);
          break;
        case METHODID_MODEL2REQUEST:
          serviceImpl.model2Request((com.example.ex3_2_back.grpc.server.message.Model2RequestMessage) request,
              (io.grpc.stub.StreamObserver<com.example.ex3_2_back.grpc.server.message.Model2ResponseMessage>) responseObserver);
          break;
        case METHODID_MODEL3REQUEST:
          serviceImpl.model3Request((com.example.ex3_2_back.grpc.server.message.Model3RequestMessage) request,
              (io.grpc.stub.StreamObserver<com.example.ex3_2_back.grpc.server.message.Model3ResponseMessage>) responseObserver);
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
          getModel1RequestMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.example.ex3_2_back.grpc.server.message.Model1RequestMessage,
              com.example.ex3_2_back.grpc.server.message.Model1ResponseMessage>(
                service, METHODID_MODEL1REQUEST)))
        .addMethod(
          getModel2RequestMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.example.ex3_2_back.grpc.server.message.Model2RequestMessage,
              com.example.ex3_2_back.grpc.server.message.Model2ResponseMessage>(
                service, METHODID_MODEL2REQUEST)))
        .addMethod(
          getModel3RequestMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.example.ex3_2_back.grpc.server.message.Model3RequestMessage,
              com.example.ex3_2_back.grpc.server.message.Model3ResponseMessage>(
                service, METHODID_MODEL3REQUEST)))
        .build();
  }

  private static abstract class GreeterBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    GreeterBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.ex3_2_back.grpc.server.message.GreeterProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Greeter");
    }
  }

  private static final class GreeterFileDescriptorSupplier
      extends GreeterBaseDescriptorSupplier {
    GreeterFileDescriptorSupplier() {}
  }

  private static final class GreeterMethodDescriptorSupplier
      extends GreeterBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    GreeterMethodDescriptorSupplier(String methodName) {
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
      synchronized (GreeterGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new GreeterFileDescriptorSupplier())
              .addMethod(getModel1RequestMethod())
              .addMethod(getModel2RequestMethod())
              .addMethod(getModel3RequestMethod())
              .build();
        }
      }
    }
    return result;
  }
}
