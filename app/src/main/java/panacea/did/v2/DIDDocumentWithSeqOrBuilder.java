// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: panacea/did/v2/did.proto

package panacea.did.v2;

public interface DIDDocumentWithSeqOrBuilder extends
    // @@protoc_insertion_point(interface_extends:panacea.did.v2.DIDDocumentWithSeq)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.panacea.did.v2.DIDDocument document = 1;</code>
   * @return Whether the document field is set.
   */
  boolean hasDocument();
  /**
   * <code>.panacea.did.v2.DIDDocument document = 1;</code>
   * @return The document.
   */
  panacea.did.v2.DIDDocument getDocument();
  /**
   * <code>.panacea.did.v2.DIDDocument document = 1;</code>
   */
  panacea.did.v2.DIDDocumentOrBuilder getDocumentOrBuilder();

  /**
   * <code>uint64 sequence = 2;</code>
   * @return The sequence.
   */
  long getSequence();
}