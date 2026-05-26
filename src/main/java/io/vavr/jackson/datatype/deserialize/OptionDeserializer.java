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

import io.vavr.control.Option;
import tools.jackson.core.JsonParser;
import tools.jackson.core.JsonToken;
import tools.jackson.databind.BeanProperty;
import tools.jackson.databind.DatabindException;
import tools.jackson.databind.DeserializationContext;
import tools.jackson.databind.JavaType;
import tools.jackson.databind.ValueDeserializer;
import tools.jackson.databind.jsontype.TypeDeserializer;

class OptionDeserializer<T> extends VavrValueDeserializer<Option<T>> {

    private final JavaType fullType;

    private final JavaType valueType;

    private final boolean plainMode;

    private final TypeDeserializer valueTypeDeserializer;

    private final ValueDeserializer<T> valueDeserializer;

    private ValueDeserializer<?> stringDeserializer;

    OptionDeserializer(JavaType fullType, JavaType valueType, TypeDeserializer typeDeser, ValueDeserializer<T> valueDeser, boolean plainMode) {
        super(fullType, 1);
        this.fullType = fullType;
        this.valueType = valueType;
        this.valueTypeDeserializer = typeDeser;
        this.valueDeserializer = valueDeser;
        this.plainMode = plainMode;
    }

    private OptionDeserializer(OptionDeserializer<T> origin, TypeDeserializer typeDeser, ValueDeserializer<T> valueDeser) {
        this(origin.fullType, origin.valueType, typeDeser, valueDeser, origin.plainMode);
        this.stringDeserializer = origin.stringDeserializer;
    }

    @Override
    public Option<T> deserialize(JsonParser p, DeserializationContext ctxt, Option<T> intoValue) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Option<T> deserialize(JsonParser p, DeserializationContext ctxt) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void resolve(DeserializationContext ctxt) throws DatabindException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Option<T> getNullValue(DeserializationContext ctxt) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ValueDeserializer<?> createContextual(DeserializationContext ctxt, BeanProperty property) throws DatabindException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Overridable fluent factory method used for creating contextual
     * instances.
     */
    private OptionDeserializer<?> withResolved(JavaType refType, TypeDeserializer typeDeser, ValueDeserializer<?> valueDeser) {
        if (refType == valueType && valueDeser == valueDeserializer && typeDeser == valueTypeDeserializer) {
            return this;
        }
        return new OptionDeserializer(this, typeDeser, valueDeser);
    }
}
