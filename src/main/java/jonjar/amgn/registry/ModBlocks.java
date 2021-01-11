package jonjar.amgn.registry;

import jonjar.amgn.Amgn;
import jonjar.amgn.block.ChocolateBlock;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import javax.imageio.ImageTranscoder;


public class ModBlocks {

    /*
    블럭 만들기
     */
    public static final Block CHOCOLATE_BLOCK = new ChocolateBlock(FabricBlockSettings
            .of(Material.METAL)
            .breakByTool(FabricToolTags.PICKAXES,0)
            //.requiresTool()
            .strength(0.75f,8.0f)
            .sounds(BlockSoundGroup.METAL)
            .ticksRandomly()
            //luminance()
    );

    public static final Block COMPRESSED_SLIME_BLOCK = new SlimeBlock(FabricBlockSettings
            .of(Material.ORGANIC_PRODUCT)
            .breakByTool(FabricToolTags.PICKAXES, 0)
            .strength(0.75f, 8.0f)
            .sounds(BlockSoundGroup.SLIME)
            .nonOpaque()
            .slipperiness(0.6f)
    );

    public static final Block COMPRESSED_RICECAKE_BLOCK = new Block(FabricBlockSettings
            .of(Material.CAKE)
            .breakByTool(FabricToolTags.SHOVELS, 0)
            .breakByHand(true)
            .strength(0.5f, 5f)
            .sounds(BlockSoundGroup.SNOW));

    public static Block MOLTEN_CHOCOLATE;
    public static Block MOLTEN_SLIME;
    /*
    블럭 등록
     */
    public static void registerBlocks(){
        Registry.register(Registry.BLOCK, new Identifier(Amgn.MODID,"chocolate_block"), CHOCOLATE_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(Amgn.MODID,"compressed_slime_block"), COMPRESSED_SLIME_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(Amgn.MODID,"compressed_ricecake_block"), COMPRESSED_RICECAKE_BLOCK);

        MOLTEN_SLIME = Registry.register(Registry.BLOCK, new Identifier(Amgn.MODID, "molten_slime"), new FluidBlock(ModFluids.STILL_SLIME, FabricBlockSettings.copy(Blocks.WATER)){});
        MOLTEN_CHOCOLATE = Registry.register(Registry.BLOCK, new Identifier(Amgn.MODID, "molten_chocolate"), new FluidBlock(ModFluids.STILL_MOLTEN_CHOCOLATE, FabricBlockSettings.copy(Blocks.WATER)){});

    }
}
