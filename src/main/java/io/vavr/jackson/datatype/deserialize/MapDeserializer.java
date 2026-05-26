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
package io.vavr.jackson.datatype.deserialize;

import io.vavr.collection.HashMap;
import io.vavr.collection.LinkedHashMap;
import io.vavr.collection.Map;
import io.vavr.collection.SortedMap;
import io.vavr.collection.TreeMap;
import tools.jackson.core.JsonParser;
import tools.jackson.core.JsonToken;
import tools.jackson.databind.DeserializationContext;
import tools.jackson.databind.KeyDeserializer;
import tools.jackson.databind.ValueDeserializer;
import tools.jackson.databind.jsontype.TypeDeserializer;
import tools.jackson.databind.type.MapLikeType;

class MapDeserializer extends MaplikeDeserializer<Map<?, ?>> {

    MapDeserializer(MapLikeType mapType, KeyDeserializer keyDeserializer, TypeDeserializer elementTypeDeserializer, ValueDeserializer<?> elementDeserializer) {
        super(mapType, keyDeserializer, elementTypeDeserializer, elementDeserializer);
    }

    MapDeserializer(MapDeserializer origin, KeyDeserializer keyDeserializer, TypeDeserializer elementTypeDeserializer, ValueDeserializer<?> valueDeserializer) {
        super(origin.mapType, keyDeserializer, elementTypeDeserializer, valueDeserializer);
    }

    @Override
    MaplikeDeserializer<Map<?, ?>> createDeserializer(KeyDeserializer keyDeserializer, TypeDeserializer elementTypeDeserializer, ValueDeserializer<?> valueDeserializer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Map<?, ?> deserialize(JsonParser p, DeserializationContext ctxt, Map<?, ?> intoValue) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private Object deserializeValue(JsonParser p, DeserializationContext ctxt, Map<?, ?> intoValue, JsonToken t, java.util.LinkedHashMap<Object, Object> result, Object key) {
        if (t == JsonToken.VALUE_NULL) {
            return elementDeserializer.getNullValue(ctxt);
        }
        if (elementTypeDeserializer == null) {
            if (intoValue != null) {
                return result.containsKey(key) ? elementDeserializer.deserialize(p, ctxt, cast(result.get(key))) : elementDeserializer.deserialize(p, ctxt);
            } else {
                return elementDeserializer.deserialize(p, ctxt);
            }
        }
        if (intoValue != null) {
            return elementDeserializer.deserializeWithType(p, ctxt, elementTypeDeserializer, cast(result.getOrDefault(key, null)));
        } else {
            return elementDeserializer.deserializeWithType(p, ctxt, elementTypeDeserializer);
        }
    }

    @Override
    public Map<?, ?> deserialize(JsonParser p, DeserializationContext ctxt) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static <T> T cast(Object o) {
        return (T) o;
    }
}
