/*
 * Copyright (C) 2015 Pedro Paulo de Amorim.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.pedrovgs.sample.renderer.rendererbuilder;

import com.github.pedrovgs.sample.renderer.VideoRenderer;
import com.github.pedrovgs.sample.viewmodel.VideoViewModel;
import com.pedrogomez.renderers.Renderer;
import com.pedrogomez.renderers.RendererBuilder;

import java.util.Collection;

/**
 * RendererBuilder implementation created to map VideoViewModel with VideoRenderer
 * implementations. More info in this link: {@link https://github.com/pedrovgs/Renderers}
 *
 * @author Pedro Paulo de Amorim
 */
public class VideoCollectionRendererBuilder extends RendererBuilder<VideoViewModel> {

  public VideoCollectionRendererBuilder(Collection<Renderer<VideoViewModel>> prototypes) {
    super(prototypes);
  }

  @Override protected Class getPrototypeClass(VideoViewModel tvShowViewModel) {
    return VideoRenderer.class;
  }
}
