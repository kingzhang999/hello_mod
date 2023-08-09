package com.example.hello_mod.set;

import com.example.hello_mod.Main;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SoundInit {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Main.MOD_ID);
    public static final RegistryObject<SoundEvent> ENTITY_KNIFE_AIPI = build("entity.knife.aipi");
    public static final RegistryObject<SoundEvent> ENTITY_ROSE_FUNERAL_MEI_GUI_HUA_DE_ZANG_LI = build("entity.rose_funeral.mei_gui_hua_de_zang_li");
    public static final RegistryObject<SoundEvent> ENTITY_BEAT_IT_BEAT_IT = build("entity.beat_it.beat_it");
    public static final RegistryObject<SoundEvent> ENTITY_BOW_DING = build("entity.bow.ding");
    private static RegistryObject<SoundEvent> build(String name){
        return SOUNDS.register(name, () -> new SoundEvent(new ResourceLocation(Main.MOD_ID, name)));
    }
}
