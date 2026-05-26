/*  __    __  __  __    __  ___
 * \  \  /  /    \  \  /  /  __/
 *  \  \/  /  /\  \  \/  /  /
 *   \____/__/  \__\____/__/
 *
 * Copyright 2014-2025 Vavr, http://vavr.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.vavr.jackson.datatype.serialize;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.vavr.Lazy;
import io.vavr.Tuple;
import io.vavr.collection.CharSeq;
import io.vavr.collection.Map;
import io.vavr.collection.Multimap;
import io.vavr.collection.PriorityQueue;
import io.vavr.collection.Seq;
import io.vavr.collection.Set;
import io.vavr.control.Either;
import io.vavr.control.Option;
import io.vavr.jackson.datatype.VavrModule;
import tools.jackson.databind.BeanDescription;
import tools.jackson.databind.JavaType;
import tools.jackson.databind.SerializationConfig;
import tools.jackson.databind.ValueSerializer;
import tools.jackson.databind.jsontype.TypeSerializer;
import tools.jackson.databind.ser.Serializers;
import tools.jackson.databind.type.CollectionLikeType;
import tools.jackson.databind.type.MapLikeType;
import tools.jackson.databind.type.ReferenceType;

public class VavrSerializers extends Serializers.Base {

    private final VavrModule.Settings settings;

    public VavrSerializers(VavrModule.Settings settings) {
        this.settings = settings;
    }

    @Override
    public ValueSerializer<?> findSerializer(SerializationConfig config, JavaType type, BeanDescription.Supplier beanDesc, JsonFormat.Value formatOverrides) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ValueSerializer<?> findReferenceSerializer(SerializationConfig config, ReferenceType type, BeanDescription.Supplier beanDesc, JsonFormat.Value formatOverrides, TypeSerializer contentTypeSerializer, ValueSerializer<Object> contentValueSerializer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ValueSerializer<?> findCollectionLikeSerializer(SerializationConfig config, CollectionLikeType collectionType, BeanDescription.Supplier beanDesc, JsonFormat.Value formatOverrides, TypeSerializer elementTypeSerializer, ValueSerializer<Object> elementValueSerializer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ValueSerializer<?> findMapLikeSerializer(SerializationConfig config, MapLikeType type, BeanDescription.Supplier beanDesc, JsonFormat.Value formatOverrides, ValueSerializer<Object> keySerializer, TypeSerializer elementTypeSerializer, ValueSerializer<Object> elementValueSerializer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
