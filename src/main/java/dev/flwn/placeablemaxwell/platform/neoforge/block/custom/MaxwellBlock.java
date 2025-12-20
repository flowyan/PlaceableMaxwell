package dev.flwn.placeablemaxwell.platform.neoforge.block.custom;

import com.mojang.serialization.MapCodec;
import dev.flwn.placeablemaxwell.MaxwellMod;
import dev.flwn.placeablemaxwell.platform.neoforge.CheckHoliday;
import dev.flwn.placeablemaxwell.platform.neoforge.Config;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
//? if <1.21.11 {
/*import net.minecraft.resources.ResourceLocation;
 *///?} else {
import net.minecraft.resources.Identifier;
//?}
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;
import org.jspecify.annotations.NonNull;

import java.util.Random;


public class MaxwellBlock extends FallingBlock {
	public static final EnumProperty<Direction> FACING = HorizontalDirectionalBlock.FACING;
	public static final EnumProperty<Config.MaxwellHoliday> HOLIDAY = EnumProperty.create("holiday", Config.MaxwellHoliday.class);

	//? if <1.21.11 {
	/*public static final ResourceLocation DAMAGE_ID = ResourceLocation.fromNamespaceAndPath(MaxwellMod.MOD_ID, "falling_maxwell_cat");
	 *///?} else {
	public static final Identifier DAMAGE_ID = Identifier.fromNamespaceAndPath(MaxwellMod.MOD_ID, "falling_maxwell_cat");
	//?}

	public static final ResourceKey<DamageType> FALLING_MAXWELL_CAT = ResourceKey.create(Registries.DAMAGE_TYPE, DAMAGE_ID);

	public MaxwellBlock(Properties properties) {
		super(properties);

		this.registerDefaultState(stateDefinition.any()
				.setValue(FACING, Direction.NORTH)
				.setValue(HOLIDAY, Config.MaxwellHoliday.NONE)
		);
	}

	@Override
	protected @NotNull InteractionResult useItemOn(ItemStack stack, BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
		if (stack.is(ItemTags.FISHES)) {
			world.addParticle(ParticleTypes.HAPPY_VILLAGER, pos.getX() + 0.5, pos.getY() + 1.2, pos.getZ() + 0.5, 0, 0.5, 0);
			if (!player.isCreative()) stack.shrink(1); // consume one fish item
			if (!world.isClientSide()) {
				// play eating sound
				world.playSound(null, pos, SoundEvents.PLAYER_BURP, SoundSource.BLOCKS, 1, new Random().nextFloat() * (1.2f - 0.8f) + 0.8f);
			}
		} else {
			world.addParticle(ParticleTypes.HEART, pos.getX() + 0.5, pos.getY() + 1.2, pos.getZ() + 0.5, 0, 0.5, 0);
			if (!world.isClientSide()) {
				world.playSound(null, pos, SoundEvents.CAT_AMBIENT, SoundSource.BLOCKS, 1, new Random().nextFloat() * (1.2f - 0.8f) + 0.8f);
			}
		}

		// Check holiday
		switch (CheckHoliday.getCurrentHoliday()) {
			case XMAS -> {
				world.setBlock(pos, state.setValue(HOLIDAY, Config.MaxwellHoliday.XMAS), 3);
			}
			case NONE -> {
				world.setBlock(pos, state.setValue(HOLIDAY, Config.MaxwellHoliday.NONE), 3);
			}
		}

		return InteractionResult.SUCCESS;
	}

	@Override
	protected @NotNull MapCodec<MaxwellBlock> codec() {
		return MapCodec.unit(this);
	}

	@Override
	public int getDustColor(BlockState state, BlockGetter level, BlockPos pos) {
		return 0;
	}

	@Override
	public void onLand(Level world, BlockPos pos, BlockState fallingBlockState, BlockState currentStateInPos, FallingBlockEntity fallingBlockEntity) {
		if (!world.isClientSide()) {
			world.playSound(null, pos, SoundEvents.CAT_AMBIENT, SoundSource.BLOCKS, 1, new Random().nextFloat() * (1.2f - 0.8f) + 0.8f);
		}
	}

	@Override
	public @NotNull DamageSource getFallDamageSource(@NonNull Entity pEntity) {
		return new DamageSource(
				pEntity.level().registryAccess().lookupOrThrow(Registries.DAMAGE_TYPE).getOrThrow(FALLING_MAXWELL_CAT),
				pEntity);
	}

	// Does 20 damage to the player when Maxwell falls on them
	@Override
	protected void falling(FallingBlockEntity fallingBlockEntity) {
		fallingBlockEntity.setHurtsEntities(1, 20);
	}

	// adds all the block state properties you want to use
	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FACING, HOLIDAY);
	}

	// gets the correct block state for the player to place
	@Override
	public BlockState getStateForPlacement(@NotNull BlockPlaceContext context) {
		var facing = this.defaultBlockState().setValue(FACING, context.getHorizontalDirection());

		switch (CheckHoliday.getCurrentHoliday()) {
			case XMAS -> {
				return this.defaultBlockState()
						.setValue(FACING, context.getHorizontalDirection())
						.setValue(HOLIDAY, Config.MaxwellHoliday.XMAS);
			}
			case NONE -> {
				return facing;
			}
		}

		return facing;
	}
}

