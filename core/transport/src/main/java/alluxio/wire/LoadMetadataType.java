/*
 * The Alluxio Open Foundation licenses this work under the Apache License, version 2.0
 * (the "License"). You may not use this work except in compliance with the License, which is
 * available at www.apache.org/licenses/LICENSE-2.0
 *
 * This software is distributed on an "AS IS" basis, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied, as more fully set forth in the License.
 *
 * See the NOTICE file distributed with this work for information regarding copyright ownership.
 */

package alluxio.wire;

import alluxio.annotation.PublicApi;
import alluxio.grpc.LoadMetadataPType;

import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

/**
 * Types for loading metadata.
 */
@PublicApi
@ThreadSafe
public enum LoadMetadataType {
  /**
   * Never loads metadata.
   */
  Never(0),
  /**
   * Loads metadata only at the first time of listing status on a directory.
   */
  Once(1),
  /**
   * Always load metadata when listing status on a directory.
   */
  Always(2),
  ;

  private final int mValue;

  LoadMetadataType(int value) {
    mValue = value;
  }

  /**
   * @return the integer value of the LoadMetadataType
   */
  public int getValue() {
    return mValue;
  }

  /**
   * @param loadMetadataType the {@link LoadMetadataType}
   * @return the proto representation of this enum
   */
  public static LoadMetadataPType toProto(LoadMetadataType loadMetadataType) {
    return LoadMetadataPType.forNumber(loadMetadataType.getValue());
  }

  /**
   * @param loadMetadataTType the proto representation of loadMetadataType
   * @return the {@link LoadMetadataType}
   */
  @Nullable
  public static LoadMetadataType fromProto(LoadMetadataPType loadMetadataTType) {
    switch (loadMetadataTType) {
      case NEVER:
        return Never;
      case ONCE:
        return Once;
      case ALWAYS:
        return Always;
      default:
        return null;
    }
  }
}
