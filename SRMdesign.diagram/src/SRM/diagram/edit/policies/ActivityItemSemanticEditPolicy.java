package SRM.diagram.edit.policies;

import java.util.Iterator;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;

import SRM.diagram.edit.commands.CapabilityCapability_activitiesCreateCommand;
import SRM.diagram.edit.commands.CapabilityCapability_activitiesReorientCommand;
import SRM.diagram.edit.commands.FunctionalityActivitiesCreateCommand;
import SRM.diagram.edit.commands.FunctionalityActivitiesReorientCommand;
import SRM.diagram.edit.commands.RoleRole_activitiesCreateCommand;
import SRM.diagram.edit.commands.RoleRole_activitiesReorientCommand;
import SRM.diagram.edit.parts.CapabilityCapability_activitiesEditPart;
import SRM.diagram.edit.parts.FunctionalityActivitiesEditPart;
import SRM.diagram.edit.parts.RoleRole_activitiesEditPart;
import SRM.diagram.part.SRMVisualIDRegistry;
import SRM.diagram.providers.SRMElementTypes;

/**
 * @generated
 */
public class ActivityItemSemanticEditPolicy extends SRMBaseItemSemanticEditPolicy {

	/**
	* @generated
	*/
	public ActivityItemSemanticEditPolicy() {
		super(SRMElementTypes.Activity_2004);
	}

	/**
	* @generated
	*/
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		View view = (View) getHost().getModel();
		CompositeTransactionalCommand cmd = new CompositeTransactionalCommand(getEditingDomain(), null);
		cmd.setTransactionNestingEnabled(false);
		for (Iterator<?> it = view.getTargetEdges().iterator(); it.hasNext();) {
			Edge incomingLink = (Edge) it.next();
			if (SRMVisualIDRegistry.getVisualID(incomingLink) == RoleRole_activitiesEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(incomingLink.getSource().getElement(), null,
						incomingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (SRMVisualIDRegistry.getVisualID(incomingLink) == CapabilityCapability_activitiesEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(incomingLink.getSource().getElement(), null,
						incomingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (SRMVisualIDRegistry.getVisualID(incomingLink) == FunctionalityActivitiesEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(incomingLink.getSource().getElement(), null,
						incomingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
		}
		EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
		if (annotation == null) {
			// there are indirectly referenced children, need extra commands: false
			addDestroyShortcutsCommand(cmd, view);
			// delete host element
			cmd.add(new DestroyElementCommand(req));
		} else {
			cmd.add(new DeleteCommand(getEditingDomain(), view));
		}
		return getGEFWrapper(cmd.reduce());
	}

	/**
	 * @generated
	 */
	protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
		Command command = req.getTarget() == null ? getStartCreateRelationshipCommand(req)
				: getCompleteCreateRelationshipCommand(req);
		return command != null ? command : super.getCreateRelationshipCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getStartCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (SRMElementTypes.RoleRole_activities_4001 == req.getElementType()) {
			return null;
		}
		if (SRMElementTypes.CapabilityCapability_activities_4002 == req.getElementType()) {
			return null;
		}
		if (SRMElementTypes.FunctionalityActivities_4003 == req.getElementType()) {
			return null;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (SRMElementTypes.RoleRole_activities_4001 == req.getElementType()) {
			return getGEFWrapper(new RoleRole_activitiesCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (SRMElementTypes.CapabilityCapability_activities_4002 == req.getElementType()) {
			return getGEFWrapper(
					new CapabilityCapability_activitiesCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (SRMElementTypes.FunctionalityActivities_4003 == req.getElementType()) {
			return getGEFWrapper(new FunctionalityActivitiesCreateCommand(req, req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * Returns command to reorient EReference based link. New link target or source
	 * should be the domain model element associated with this node.
	 * 
	 * @generated
	 */
	protected Command getReorientReferenceRelationshipCommand(ReorientReferenceRelationshipRequest req) {
		switch (getVisualID(req)) {
		case RoleRole_activitiesEditPart.VISUAL_ID:
			return getGEFWrapper(new RoleRole_activitiesReorientCommand(req));
		case CapabilityCapability_activitiesEditPart.VISUAL_ID:
			return getGEFWrapper(new CapabilityCapability_activitiesReorientCommand(req));
		case FunctionalityActivitiesEditPart.VISUAL_ID:
			return getGEFWrapper(new FunctionalityActivitiesReorientCommand(req));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}

}
