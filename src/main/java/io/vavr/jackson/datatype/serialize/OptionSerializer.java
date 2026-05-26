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

import io.vavr.control.Option;
import tools.jackson.core.JsonGenerator;
import tools.jackson.core.JsonToken;
import tools.jackson.databind.AnnotationIntrospector;
import tools.jackson.databind.BeanProperty;
import tools.jackson.databind.DatabindException;
import tools.jackson.databind.JavaType;
import tools.jackson.databind.MapperFeature;
import tools.jackson.databind.SerializationContext;
import tools.jackson.databind.ValueSerializer;
import tools.jackson.databind.annotation.JsonSerialize;
import tools.jackson.databind.introspect.Annotated;
import tools.jackson.databind.jsontype.TypeSerializer;
import tools.jackson.databind.util.NameTransformer;

class OptionSerializer extends HListSerializer<Option<?>> {

    private final boolean plainMode;

    private final TypeSerializer valueTypeSerializer;

    private final ValueSerializer<Object> valueSerializer;

    private final JavaType fullType;

    private final JavaType valueType;

    @SuppressWarnings("unchecked")
    OptionSerializer(JavaType fullType, JavaType valueType, TypeSerializer valueTypeSerializer, ValueSerializer<?> valueSerializer, boolean plainMode) {
        super(fullType);
        this.fullType = fullType;
        this.valueType = valueType;
        this.plainMode = plainMode;
        this.valueTypeSerializer = valueTypeSerializer;
        this.valueSerializer = (ValueSerializer<Object>) valueSerializer;
    }

    JavaType getValueType() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void serialize(Option<?> value, JsonGenerator gen, SerializationContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void serializeWithType(Option<?> value, JsonGenerator gen, SerializationContext context, TypeSerializer typeSer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean isEmpty(SerializationContext provider, Option<?> value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ValueSerializer<?> createContextual(SerializationContext provider, BeanProperty property) throws DatabindException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private boolean useStatic(SerializationContext context, BeanProperty property, JavaType referredType) {
        // First: no serializer for `Object.class`, must be dynamic
        if (referredType.isJavaLangObject()) {
            return false;
        }
        // cannot use static typing, if polymorphic serialization is required
        if (valueTypeSerializer != null) {
            return false;
        }
        // but if type is final, might as well fetch
        if (referredType.isFinal()) {
            // or should we allow annotation override? (only if requested...)
            return true;
        }
        // also: if indicated by typing, should be considered static
        if (referredType.useStaticType()) {
            return true;
        }
        // if neither, maybe explicit annotation?
        AnnotationIntrospector intr = context.getAnnotationIntrospector();
        if ((intr != null) && (property != null)) {
            Annotated ann = property.getMember();
            if (ann != null) {
                JsonSerialize.Typing t = intr.findSerializationTyping(context.getConfig(), property.getMember());
                if (t == JsonSerialize.Typing.STATIC) {
                    return true;
                }
                if (t == JsonSerialize.Typing.DYNAMIC) {
                    return false;
                }
            }
        }
        // and finally, may be forced by global static typing (unlikely...)
        return context.isEnabled(MapperFeature.USE_STATIC_TYPING);
    }

    private OptionSerializer withResolved(JavaType refType, TypeSerializer typeSer, ValueSerializer<?> valueSer) {
        if (refType == fullType && typeSer == valueTypeSerializer && valueSer == valueSerializer) {
            return this;
        }
        return new OptionSerializer(refType, valueType, typeSer, valueSer, plainMode);
    }

    @Override
    public ValueSerializer<Option<?>> unwrappingSerializer(NameTransformer unwrapper) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
