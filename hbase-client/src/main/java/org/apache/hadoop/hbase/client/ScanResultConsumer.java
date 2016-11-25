/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.hadoop.hbase.client;

import org.apache.hadoop.hbase.classification.InterfaceAudience;
import org.apache.hadoop.hbase.classification.InterfaceStability;

/**
 * Receives {@link Result} for an asynchronous scan.
 */
@InterfaceAudience.Public
@InterfaceStability.Unstable
public interface ScanResultConsumer {

  /**
   * @param result the data fetched from HBase service.
   * @return {@code false} if you want to terminate the scan process. Otherwise {@code true}
   */
  boolean onNext(Result result);

  /**
   * Indicate that we hit an unrecoverable error and the scan operation is terminated.
   * <p>
   * We will not call {@link #onComplete()} after calling {@link #onError(Throwable)}.
   */
  void onError(Throwable error);

  /**
   * Indicate that the scan operation is completed normally.
   */
  void onComplete();

}
