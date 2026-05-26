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

import java.util.ArrayList;
import java.util.List;
import tools.jackson.core.JsonToken;
import tools.jackson.databind.DatabindException;
import tools.jackson.databind.DeserializationContext;
import tools.jackson.databind.JavaType;
import tools.jackson.databind.ValueDeserializer;
import tools.jackson.databind.deser.std.StdDeserializer;

abstract class VavrValueDeserializer<T> extends StdDeserializer<T> {

    private final JavaType javaType;

    private final int typeCount;

    private final List<ValueDeserializer<Object>> deserializers;

    VavrValueDeserializer(JavaType valueType, int typeCount) {
        super(valueType);
        this.javaType = valueType;
        this.typeCount = typeCount;
        this.deserializers = new ArrayList<>(typeCount);
    }

    int deserializersCount() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    ValueDeserializer<Object> deserializer(int index) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void resolve(DeserializationContext ctxt) throws DatabindException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static DatabindException mappingException(DeserializationContext ctxt, Class<?> targetClass, JsonToken token) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static String _calcName(Class<?> cls) {
        if (cls.isArray()) {
            return _calcName(cls.getComponentType()) + "[]";
        }
        return cls.getName();
    }
}
